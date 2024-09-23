package back.cmm.module.cmm.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long boardUid;
    private String boardNm;
    private String boardDescription;
    private char useCommentYn;
    private char useRecommendYn;
    private char useReportYn;
    private char useBoardYn;

}
