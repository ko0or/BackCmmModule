package back.cmm.module.cmm.comment.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.post.domain.PostBean;
import back.cmm.module.cmm.security.domain.UserBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "`comment`")
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

    @Column(name = "post_uid")
    private Long postUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", referencedColumnName = "username", insertable = false, updatable = false)
    private UserBean user;

// 댓글 정보 불러올때, 해당 게시판 정보가 굳이 필요한가 .. ?
/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_uid", referencedColumnName = "post_uid", insertable = false, updatable = false)
    private PostBean post;*/

    @Column(name = "parent_cmmt_uid")
    private Long parentCmmtUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_cmmt_uid", referencedColumnName = "cmmt_uid", insertable = false, updatable = false)
    private CommentBean parent;

    @OneToMany(mappedBy = "parent")
    private List<CommentBean> children;

}
