package back.cmm.module.cmm.base.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class ModOnlyBean extends RegOnlyBean {

    @LastModifiedDate
    @Column(name = "mod_dttm", updatable = false)
    private Date modDttm;

    @LastModifiedBy
    @Column(name = "mod_id", length = 255, updatable = false)
    private String modId;

}
