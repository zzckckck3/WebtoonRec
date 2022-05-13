package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}