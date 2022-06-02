package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.FavWebtoonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FavWebtoonRepository extends JpaRepository<FavWebtoonEntity, Long> {
    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "delete from FavWebtoonEntity f where f.webtoonId=:webtoonId and f.memberEmail=:memberEmail")
    void del(@Param("webtoonId")String webtoonId, @Param("memberEmail")String memberEmail) throws Exception;
}