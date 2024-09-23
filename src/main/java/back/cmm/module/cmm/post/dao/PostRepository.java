package back.cmm.module.cmm.post.dao;

import back.cmm.module.cmm.post.domain.PostBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostBean, Long>, CustomPostRepository {



}
