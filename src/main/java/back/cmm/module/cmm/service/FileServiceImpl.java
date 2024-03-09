package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.FileBean;
import back.cmm.module.cmm.dto.FileDto;
import back.cmm.module.cmm.repository.FileRepository;
import back.cmm.module.cmm.util.FileUtil;
import back.cmm.module.cmm.util.MapperUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileUtil fileUtil;
    private final MapperUtil mapperUtil;

    @Override
    @Transactional
    public ResponseEntity<Resource> read(String logicalNm) {
        Optional<FileBean> fileBean = fileRepository.findByLogicalNm(logicalNm);
        if (fileBean.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        FileDto fileDto = mapperUtil.map(fileBean.get(), FileDto.class);
        Path filePath = Paths.get(fileDto.getPath(), fileDto.getLogicalNm());

        try {
            // 파일 경로 검증 로직 추가 (예: Path Traversal 공격 방지)
            if (!filePath.normalize().startsWith(fileDto.getPath())) {
                throw new SecurityException("Invalid file path");
            }

            Resource fileResource = new UrlResource(filePath.toUri());
            if (!fileResource.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            String mimeType = Files.probeContentType(filePath);
            MediaType mediaType = (mimeType != null) ? MediaType.parseMediaType(mimeType) : MediaType.APPLICATION_OCTET_STREAM;

            // 파일명 인코딩 처리
            String encodedFileName = URLEncoder.encode(fileDto.getPhysicalNm(), StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
            String contentDisposition = "attachment; filename*=UTF-8''" + encodedFileName;

            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .body(fileResource);

        } catch (IOException | SecurityException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @Override
    @Transactional
    public void save(MultipartFile[] files) throws IOException {

        Path uploadPath = fileUtil.determineUploadPath();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            // 업로드 대상 파일 확장자 검사, 허용된 확장자일경우 파일 저장
            fileUtil.validateFileExtension(file);
            String originalFilename = file.getOriginalFilename();
            String logicalFileName = UUID.randomUUID().toString() + "_" + originalFilename;
            Path filePath = uploadPath.resolve(logicalFileName);
            file.transferTo(filePath.toFile());
            // FileBean 엔티티 생성 및 저장
            FileBean fileBean = new FileBean();
            fileBean.setLogicalNm(logicalFileName); // 식별용 이름
            fileBean.setPhysicalNm(originalFilename); // 실제 파일명
            fileBean.setPath(uploadPath.toString()); // 실제 파일 경로
            fileRepository.save(fileBean);
        }


    }


    @Override
    @Transactional
    public void delete(String logicalNm) {
        fileRepository.deleteByLogicalNm(logicalNm);
    }
}
