package back.cmm.module.cmm.web;

import back.cmm.module.cmm.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "File API", description = "파일 업로드, 삭제, 다운로드 및 이미지 표시 (준비중..)")
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileApi {
    private final FileService fileService;

    // IMG DISPLAY
    @GetMapping("display/{logicalNm:.+}")
    @Operation(summary = "이미지 표시")
    public ResponseEntity<byte[]> displayImg(@PathVariable("logicalNm") String logicalNm){
        try {
            return fileService.read(logicalNm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // FILE DOWNLOAD
    @GetMapping("{logicalNm:.+}")
    @Operation(summary = "파일 다운로드")
    public ResponseEntity<byte[]> download(@PathVariable("logicalNm") String logicalNm) {
        try {
            return fileService.read(logicalNm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // FILE SAVE
    @PostMapping
    @Operation(summary = "파일 업로드")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile[] files)  {
        try {
            fileService.save(files);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (IOException e) { // IOException 처리
            return new ResponseEntity<>("파일 업로드 중 오류가 발생했습니다: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // FILE DELETE
    @DeleteMapping("{logicalNm:.+}")
    @Operation(summary = "파일 삭제")
    public void del(@PathVariable("logicalNm") String logicalNm) {
        fileService.delete(logicalNm);
    }

}
