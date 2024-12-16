package back.cmm.module.cmm.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private String boardId;
    private String boardNm;
    private String boardDes;
    private char cmmtUseYn;
    private char rcmdUseYn;
    private char reportUseYn;
    private char boardUseYn;

}
