package back.cmm.module.cmm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
    ResponseEntity<byte[]> read(String logicalNm) throws IOException;

    void save(MultipartFile[] files) throws IOException;

    void delete(String logicalNm);
}
