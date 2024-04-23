package back.cmm.module.cmm.file.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    ResponseEntity<Resource> read(String logicalNm) throws IOException;

    String save(MultipartFile[] files) throws IOException;

    void delete(String logicalNm);
}
