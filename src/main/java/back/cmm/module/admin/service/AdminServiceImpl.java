package back.cmm.module.admin.service;

import back.cmm.module.cmm.base.util.ExecUtil;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource private ExecUtil execUtil;

    @Override
    @SneakyThrows
    public void updateProject(MultipartFile file) {

        String targetDirectory = "C:\\Users\\mw";
        String targetFileName = "tmp-dms.jar";
        Path targetPath = Path.of(targetDirectory, targetFileName);
        file.transferTo(targetPath.toFile());

        String batchFilePath = "C:\\Users\\mw\\deploy-dms.bat";
        new ProcessBuilder("cmd.exe", "/c", "start", batchFilePath).directory(new File(targetDirectory)).start();

    }

}
