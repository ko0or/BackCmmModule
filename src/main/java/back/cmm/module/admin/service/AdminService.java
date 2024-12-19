package back.cmm.module.admin.service;

import org.springframework.web.multipart.MultipartFile;

public interface AdminService {
    void updateProject(MultipartFile file);
}
