package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WebtoonCsRepository {
    private final EntityManager em;

    public List<WebtoonEntity> findAll( int offset, int limit ){

        return em.createQuery("select w from WebtoonEntity w").setFirstResult(offset).setMaxResults(limit).getResultList();
    }
    public List<WebtoonEntity> findAlll( ){

        return em.createQuery("select w from WebtoonEntity w").getResultList();
    }

    public List<WebtoonEntity> findAllwithKeyword( String keyword ){
        return em.createQuery("select w from WebtoonEntity w where w.webtoon_keyword like concat('%',:keyword,'%')").setParameter("keyword",keyword ).getResultList();
    }

    public List<WebtoonEntity> findAllwithName( String name ){
        return em.createQuery("select w from WebtoonEntity w where w.webtoon_name like %@name%").setParameter("name", name).getResultList();
    }
}
