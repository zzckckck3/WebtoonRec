package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebtoonRepository extends JpaRepository<WebtoonEntity, String> {
    //JpaRepository 상속중<사용할 Entity, Entitiy에서 사용되는 Id의 데이터종류>
}
