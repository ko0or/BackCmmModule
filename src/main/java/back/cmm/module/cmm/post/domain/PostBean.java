package back.cmm.module.cmm.post.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.board.domain.BoardBean;
import back.cmm.module.cmm.comment.domain.CommentBean;
import back.cmm.module.cmm.security.domain.UserBean;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@Table(name = "`post`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBean extends RegBasicBean {

    @Id
    @Column(name = "post_uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postUid;

    @Column(name = "title")
    private String title;

    @Column(name = "`content`", columnDefinition = "text")
    private String content;

    @Column(name = "thumb_img")
    private String thumbImg;

    @Column(name = "thumb_content")
    private String thumbContent;

    @Column(name = "board_id")
    private String boardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id", insertable = false, updatable = false)
    private BoardBean board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", referencedColumnName = "username", insertable = false, updatable = false)
    private UserBean user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_uid", referencedColumnName = "post_uid")
    private List<CommentBean> comments;

}
