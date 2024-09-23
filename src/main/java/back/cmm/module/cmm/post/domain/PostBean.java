package back.cmm.module.cmm.post.domain;

import back.cmm.module.cmm.base.domain.RegBasicBean;
import back.cmm.module.cmm.board.domain.BoardBean;
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
public class PostBean extends RegBasicBean {

    @Id
    @Column(name = "post_uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postUid;

    @Column(name = "title")
    private String title;

    @Column(name = "`content`")
    private String content;

    @Column(name = "thumb_img")
    private String thumbImg;

    @Column(name = "thumb_content")
    private String thumbContent;

    /*private Long boardUid;*/
    /*private Long userUid;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_uid", referencedColumnName = "board_uid", insertable = false, updatable = false)
    private BoardBean board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id", referencedColumnName = "username", insertable = false, updatable = false)
    private UserBean user;

}
