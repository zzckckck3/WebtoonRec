package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.FavWebtoonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class FavWebtoonCsRepository {
    private final EntityManager em;

    public Long save(FavWebtoonEntity favWebtoonEntity){
        em.persist(favWebtoonEntity);

        return favWebtoonEntity.getId();
    }

    public List<FavWebtoonEntity> findAll(){
        return em.createQuery("select f from FavWebtoonEntity f").getResultList();
    }

    public List<FavWebtoonEntity> findAllbyEmail(String email){
        return em.createQuery("select f from FavWebtoonEntity f where f.memberEmail = :email")
                .setParameter("memberEmail", email).getResultList();
    }
}
