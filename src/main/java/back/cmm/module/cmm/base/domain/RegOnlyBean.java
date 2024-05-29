package back.cmm.module.cmm.base.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class RegOnlyBean implements Serializable {

    @CreatedDate
    @Column(name = "reg_dttm", updatable = false)
    private Date regDttm;

    @CreatedBy
    @Column(name = "reg_id", length = 255, updatable = false)
    private String regId;

}
