package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberCsRepository {
    private final EntityManager em;

    public Long save(MemberEntity memberEntity) {
        em.persist(memberEntity);

        return memberEntity.getId();
    }

    public List<MemberEntity> findAll(int offset, int limit) {
        return em.createQuery("select mlist from MemberEntity mlist").setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public MemberEntity findByEmail(String email){
        return em.createQuery("select m from MemberEntity m where m.email = :email", MemberEntity.class)
                .setParameter("email", email).getSingleResult();
    }




    /*
    @Modifying
    @Transactional
    public MemberEntity plus(String webtoonId, String email){
        return em.createQuery("update MemberEntity m set m.favWebtoon=:webtoonId where m.email=:email", MemberEntity.class)
                .setParameter("webtoonId", webtoonId).setParameter("email", email).getSingleResult();
    }
     */
    /*
    public List<MemberEntity> addfavWebtoon(String webtoonId, String email){
        return em.createQuery("update MemberEntity m set m.favWebtoon = :webtoonId where m.email=:email", MemberEntity.class)
                .setParameter("webtoonId", webtoonId).setParameter("email", email).getResultList();
    }
    */
}
