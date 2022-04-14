package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Domain.TestDB;
import https.github.com.zzckckck3.WebtoonRec.Repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //const변수들 자동으로 생성자를 만들어준다
public class TestService {
    private final TestRepository repository;
    public Long TestDB(TestDB db){
        Long saveId = repository.save(db);
        return saveId;
    }
}
