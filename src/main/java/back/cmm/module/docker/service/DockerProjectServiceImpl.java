package back.cmm.module.docker.service;

import back.cmm.module.cmm.base.util.MapperUtil;
import back.cmm.module.docker.dao.DockerProjectRepository;
import back.cmm.module.docker.domain.DockerProjectBean;
import back.cmm.module.docker.dto.DockerProjectDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DockerProjectServiceImpl implements DockerProjectService {

    private final DockerProjectRepository dockerProjectRepository;
    private final MapperUtil mapperUtil;

    @Override
    public List<DockerProjectDto> list() {
        List<DockerProjectBean> beans = dockerProjectRepository.findAll();
        return mapperUtil.map(beans, DockerProjectDto.class);
    }

    @Override
    @Transactional
    public void save(DockerProjectDto dto) {
        DockerProjectBean bean = mapperUtil.map(dto, DockerProjectBean.class);
        dockerProjectRepository.save(bean);
    }

    @Override
    @Transactional
    public void delete(DockerProjectDto dto) {
        dockerProjectRepository.deleteById(dto.getProjectUid());
    }

}
