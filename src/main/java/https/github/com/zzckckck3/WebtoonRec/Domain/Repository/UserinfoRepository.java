package https.github.com.zzckckck3.WebtoonRec.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Domain.Entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
    Optional<Userinfo> findByEmail(String email);

}