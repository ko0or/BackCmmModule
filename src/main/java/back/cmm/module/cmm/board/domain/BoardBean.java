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
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String boardId;

    @Column(name = "board_nm")
    private String boardNm;

    @Column(name = "board_des")
    private String boardDes;

    @Column(name = "cmmt_use_yn", length = 1)
    private char cmmtUseYn;

    @Column(name = "rcmd_use_yn", length = 1)
    private char rcmdUseYn;

    @Column(name = "reportUseYn", length = 1)
    private char reportUseYn;

    @Column(name = "board_use_yn", length = 1)
    private char boardUseYn;

}
