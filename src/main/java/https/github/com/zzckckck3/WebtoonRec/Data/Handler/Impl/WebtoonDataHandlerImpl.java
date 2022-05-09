package https.github.com.zzckckck3.WebtoonRec.Data.Handler.Impl;

import https.github.com.zzckckck3.WebtoonRec.Data.Dao.WebtoonDao;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Handler.WebtoonDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class WebtoonDataHandlerImpl implements WebtoonDataHandler {

    WebtoonDao webtoonDao;

    @Autowired
    public WebtoonDataHandlerImpl(WebtoonDao webtoonDao) {
        this.webtoonDao = webtoonDao;
    }

    @Override
    public WebtoonEntity saveWebtoonEntity(String webtoonId, String webtoonName, String webtoonURL, String webtoonKeyword){
        WebtoonEntity webtoonEntity = new WebtoonEntity(webtoonId, webtoonName, webtoonURL, webtoonKeyword);

        return webtoonDao.saveWebtoon(webtoonEntity);
    }

    @Override
    public WebtoonEntity getWebtoonEntity(String webtoonId){
        return webtoonDao.getWebtoon(webtoonId);
    }
}
