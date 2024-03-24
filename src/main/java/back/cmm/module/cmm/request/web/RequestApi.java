package back.cmm.module.cmm.request.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Request API", description = "외부 API 요청 및 요청 결과 처리")
@RestController
@RequiredArgsConstructor
@RequestMapping("/request")
public class RequestApi {

    @GetMapping
    @Operation(summary = "example")
    public void example() {
        // nothing ..
    }

}
