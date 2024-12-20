package back.cmm.module.cmm.base.util;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class JpaPaging {

    private List<?> list;
    private long total;

    public JpaPaging(Page<?> page, Class<?> clazz) {
        ModelMapper mapper = new ModelMapper();
        this.list = page.stream().map(o -> mapper.map(o, clazz)).collect(Collectors.toList());
        this.total = page.getTotalElements();
    }

}