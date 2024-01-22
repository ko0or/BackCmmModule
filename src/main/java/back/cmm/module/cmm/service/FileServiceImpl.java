package back.cmm.module.cmm.service;

import back.cmm.module.cmm.domain.FileBean;
import back.cmm.module.cmm.dto.FileDto;
import back.cmm.module.cmm.repository.FileRepository;
import back.cmm.module.cmm.util.FileUtil;
import back.cmm.module.cmm.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public ResponseEntity<byte[]> read(String logicalNm) throws IOException {
            Optional<FileBean> fileBean = fileRepository.findByLogicalNm(logicalNm);
            if (fileBean.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            FileDto fileDto = mapperUtil.map(fileBean.get(), FileDto.class);
            File file = new File(fileDto.getPath() + File.separator + fileDto.getPhysicalNm());
            if (file.exists()) {
                String mimeType = null;
                mimeType = Files.probeContentType(file.toPath());
                MediaType mediaType = mimeType != null ? MediaType.parseMediaType(mimeType) : MediaType.APPLICATION_OCTET_STREAM;

                return ResponseEntity.status(HttpStatus.OK)
                        .contentType(mediaType)
                        .body(Files.readAllBytes(file.toPath()));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

    }


    @Override
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
    public void delete(String logicalNm) {
        fileRepository.deleteByLogicalNm(logicalNm);
    }
}
