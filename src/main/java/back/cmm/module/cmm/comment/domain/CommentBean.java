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

    @Column(name = "`content`")
    private String content;

    @Column(name = "board_uid")
    private Long boardUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", referencedColumnName = "username", insertable = false, updatable = false)
    private UserBean user;

}
