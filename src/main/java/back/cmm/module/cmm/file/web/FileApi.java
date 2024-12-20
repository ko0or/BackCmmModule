package back.cmm.module.cmm.file.web;

import back.cmm.module.cmm.file.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "File API", description = "파일 업로드, 삭제, 다운로드 및 이미지 표시 (준비중..)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileApi {
    private final FileService fileService;

    // IMG DISPLAY
    @GetMapping("img/{logicalNm:.+}")
    @Operation(summary = "이미지 표시")
    public ResponseEntity<Resource> displayImg(@PathVariable("logicalNm") String logicalNm){
        try {
            return fileService.read(logicalNm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // FILE DOWNLOAD
    @GetMapping("download/{logicalNm:.+}")
    @Operation(summary = "파일 다운로드")
    public ResponseEntity<Resource> download(@PathVariable("logicalNm") String logicalNm) {
        try {
            return fileService.read(logicalNm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // FILE SAVE
    @PostMapping("upload")
    @Operation(summary = "파일 업로드")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile[] files)  {
        try {
            fileService.save(files);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (IOException e) { // IOException 처리
            return new ResponseEntity<>("파일 업로드 중 오류가 발생했습니다: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("ckeditor/img-upload")
    @Operation(summary = "파일 업로드")
    public Map<String, Object> ckEditorImgUpload(@RequestParam("upload") MultipartFile[] files, HttpServletRequest hsr)  {
        Map<String, Object> responseData = new HashMap<>();
        try {
            String basePath = hsr.getScheme() + "://" + hsr.getServerName() + ":" + hsr.getServerPort() + "/file/img/";
            String savedPath = basePath + fileService.save(files);
            responseData.put("uploaded", true);
            responseData.put("url", savedPath);
            return responseData;
        } catch (IOException e) {
            responseData.put("uploaded", false);
            responseData.put("url", null);
            return null;
        }
    }

    // FILE DELETE
    @DeleteMapping("delete/{logicalNm:.+}")
    @Operation(summary = "파일 삭제")
    public void del(@PathVariable("logicalNm") String logicalNm) {
        fileService.delete(logicalNm);
    }

}
