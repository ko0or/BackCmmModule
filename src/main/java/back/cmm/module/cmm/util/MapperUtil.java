package back.cmm.module.cmm.util;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {
    private final ModelMapper modelMapper;
    public MapperUtil() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    /* 단일 매핑 */
    public <S, T> T map(S srcObj, Class<T> targetClass) {
        return modelMapper.map(srcObj, targetClass);
    }
    /* 여러개 매핑  */
    public <S, T> List<T> map(List<S> srcObjList, Class<T> targetClass) {
        return srcObjList.stream()
                .map(srcObj -> modelMapper.map(srcObj, targetClass))
                .collect(Collectors.toList());
    }
    /* 데이터 복사 + 붙여넣기 */
    public <S, T> void map(S srcObj, T targetObj) {
        modelMapper.map(srcObj, targetObj);
    }
}
