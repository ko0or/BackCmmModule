package back.cmm.module.cmm.base.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class FileUtil {

    public Path determineUploadPath() throws IOException {
        String subFolder = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy" + File.separator + "MM"));
        Path uploadPath = Paths.get("C:" + File.separator + "download", subFolder);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        return uploadPath;
    }

    public void validateFileExtension(MultipartFile file) throws IOException {
        List<String> disallowedExtensions = Arrays.asList("exe", "bat", "shell");
        String originalFilename = file.getOriginalFilename();

        if (originalFilename != null) {
            String fileExtension = originalFilename.contains(".")
                    ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1)
                    : "";

            if (disallowedExtensions.contains(fileExtension.toLowerCase())) {
                throw new IOException("업로드가 금지된 파일 형식입니다: " + originalFilename);
            }
        }
    }
}
