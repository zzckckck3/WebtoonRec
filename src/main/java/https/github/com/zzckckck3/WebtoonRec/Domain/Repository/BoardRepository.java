package https.github.com.zzckckck3.WebtoonRec.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Domain.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}