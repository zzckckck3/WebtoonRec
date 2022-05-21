package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String userEmail);
}