package back.cmm.module.cmm.comment.dao;

import back.cmm.module.cmm.comment.domain.CommentBean;
import back.cmm.module.cmm.comment.dto.CommentDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentBean, Long>, CustomCommentRepository {

    List<CommentBean> findAllByParentCmmtUidIsNull();
    List<CommentBean> findAllByParentCmmtUidIsNullAndPostUidEquals(Long postUid);
    List<CommentBean> findAllByParentCmmtUidIsNullAndPostUidEqualsAndDelYnEquals(Long postUid, String n, Sort regDttm);

    Long countByPostUid(Long postUid);
    Long countByPostUidAndDelYnEquals(Long postUid, String n);

}
