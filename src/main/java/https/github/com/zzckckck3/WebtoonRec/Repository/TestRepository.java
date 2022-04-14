package https.github.com.zzckckck3.WebtoonRec.Repository;

import https.github.com.zzckckck3.WebtoonRec.Domain.TestDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class TestRepository {
    private final EntityManager EM;
    public Long save(TestDB test){
        EM.persist(test);
        Long saveid = test.getId();

        return saveid;
    }
}
