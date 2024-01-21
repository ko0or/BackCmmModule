package back.cmm.module.cmm.domain;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegBasicBean extends ModOnlyBean {
    @Column(name = "del_yn", length = 1)
    private String delYn = "N";

    public void delete() {
        delYn = "Y";
    }
}