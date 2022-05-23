package https.github.com.zzckckck3.WebtoonRec.Data.Dao.impl;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.WebtoonRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Dao.WebtoonDao;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  WebtoonDaoImpl implements WebtoonDao {
    WebtoonRepository webtoonRepository;

    @Autowired //Dao에서는 repository를 활용해 코드를 작성하는데, 이 annotation을 활용해 객체를 주입받는다.(자동연결, 의존성 주입)
    //Springboot는 Singleton을 기반으로 하기에, Repo가 필요할 떄마다 객체를 생성하지 않고 미리 repo를 만들어놓고 여러곳에서 사용하는 방식을 택한다.
    public WebtoonDaoImpl(WebtoonRepository webtoonRepository){
        this.webtoonRepository = webtoonRepository;
    }

    @Override
    public WebtoonEntity saveWebtoon(WebtoonEntity webtoonEntity){
        webtoonRepository.save(webtoonEntity); //이를 통해 DB에 저장
        return webtoonEntity;
    }

    @Override
    public WebtoonEntity getWebtoon(String webtoonId){
        WebtoonEntity webtoonEntity = webtoonRepository.getById(webtoonId); //Id를 기반으로 데이터를 끌어옴
        return webtoonEntity;
    }
}
