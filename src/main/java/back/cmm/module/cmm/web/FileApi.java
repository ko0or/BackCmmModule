package back.cmm.module.cmm.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "File API", description = "파일 업로드, 삭제, 다운로드 및 이미지 표시")
@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileApi {

    // IMG DISPLAY
    @GetMapping("img")
    @Operation(summary = "이미지 표시")
    public void displayImg() {

    }
    // FILE DOWNLOAD
    @GetMapping
    @Operation(summary = "파일 다운로드")
    public void read() {

    }
    // FILE SAVE
    @PostMapping
    @Operation(summary = "파일 저장")
    public void save() {

    }
    // FILE DELETE
    @DeleteMapping
    @Operation(summary = "파일 삭제")
    public void del() {

    }

}
