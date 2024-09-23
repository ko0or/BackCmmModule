package back.cmm.module.cmm.comment.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.security.domain.UserBean;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`post`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentBean extends RegBasicBean {

    @Id
    @Column(name = "cmmt_uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cmmtUid;

    @Column(name = "cmmt_grp_uid")
    private Long cmmtGrpUid;

    @Column(name = "`content`")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", referencedColumnName = "username", insertable = false, updatable = false)
    private UserBean user;

}
