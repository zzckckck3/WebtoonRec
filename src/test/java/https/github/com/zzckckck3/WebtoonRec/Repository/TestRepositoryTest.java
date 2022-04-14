package https.github.com.zzckckck3.WebtoonRec.Repository;

import https.github.com.zzckckck3.WebtoonRec.Domain.TestDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest //테스트 안붙일 시 자바실행됨 >> 종합테스트 annnotation
@Transactional //DB transaction시에 항상 붙여줘야함 (관리)
@Rollback(value = true) //'test'에서만 사용 transaction과 항상 같이 사용 --> 함수 종료 시 원상태로 돌아감
public class TestRepositoryTest {
    @Autowired //의존성 주입 >> 실행 시 자동으로 객체를 할당 (singleTon)(bean)
    TestRepository repository;
    @Test //개별 테스트를 실행할 수 있도록 해줌 >> 단위테스트 annnotation
    public void 테스트(){
        TestDB testDB = new TestDB();
        testDB.setMain("테스트임");

        Long Id = repository.save(testDB);
        System.out.println(Id.toString());
    }
}