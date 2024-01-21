package back.cmm.module.cmm.domain;

import back.cmm.module.cmm.util.SecurityUtil;
import jakarta.persistence.Column;
import lombok.Getter;

import java.util.Date;

@Getter
public class ModOnlyBean extends RegOnlyBean {
    @Column(name = "mod_dttm", updatable = false)
    private Date modDttm;

    @Column(name = "mod_id", length = 20, updatable = false)
    private String modId;

    public ModOnlyBean() {
        this.modDttm = new Date();
        modId = SecurityUtil.getCurrentUsername().orElse(null);
    }
}
