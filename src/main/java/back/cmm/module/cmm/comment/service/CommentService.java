package back.cmm.module.cmm.comment.service;

import back.cmm.module.cmm.comment.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getList();

    CommentDto save(CommentDto commentDto);
}
