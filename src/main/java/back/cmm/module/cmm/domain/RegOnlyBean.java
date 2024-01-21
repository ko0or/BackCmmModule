package back.cmm.module.cmm.domain;

import back.cmm.module.cmm.util.SecurityUtil;
import jakarta.persistence.Column;
import lombok.Getter;
import java.util.Date;

@Getter
public class RegOnlyBean {
    @Column(name = "reg_dttm", updatable = false)
    private Date regDttm;

    @Column(name = "reg_id", length = 20, updatable = false)
    private String regId;

    public RegOnlyBean() {
        this.regDttm = new Date();
        regId = SecurityUtil.getCurrentUsername().orElse(null);
    }
}
