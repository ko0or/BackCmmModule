package back.cmm.module.cmm.comment.dao;

import back.cmm.module.cmm.comment.domain.CommentBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentBean, Long>, CustomCommentRepository {



}
