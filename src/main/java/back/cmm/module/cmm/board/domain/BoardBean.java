package back.cmm.module.cmm.board.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`board`")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardBean {

    @Id
    @Column(name = "board_uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardUid;

    @Column(name = "board_nm")
    private String boardNm;

    @Column(name = "board_description")
    private String boardDescription;

    @Column(name = "use_comment_yn", length = 1)
    private char useCommentYn;

    @Column(name = "use_recommend_yn", length = 1)
    private char useRecommendYn;

    @Column(name = "use_report_yn", length = 1)
    private char useReportYn;

    @Column(name = "use_board_yn", length = 1)
    private char useBoardYn;

}
