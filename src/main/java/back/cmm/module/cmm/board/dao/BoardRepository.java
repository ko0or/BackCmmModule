package back.cmm.module.cmm.board.dao;

import back.cmm.module.cmm.board.domain.BoardBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardBean, String> {



}
