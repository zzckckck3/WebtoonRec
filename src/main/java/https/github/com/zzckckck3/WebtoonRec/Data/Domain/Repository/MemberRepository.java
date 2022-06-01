package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "update MemberEntity m set m.favWebtoon=:webtoonId where m.email=:email", nativeQuery = true)
    void plus(@Param("webtoonId")String webtoonId, @Param("email")String email) throws Exception;
}