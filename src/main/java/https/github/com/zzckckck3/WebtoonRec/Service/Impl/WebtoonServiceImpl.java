package https.github.com.zzckckck3.WebtoonRec.Service.Impl;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;
import https.github.com.zzckckck3.WebtoonRec.Data.Handler.WebtoonDataHandler;
import https.github.com.zzckckck3.WebtoonRec.Service.WebtoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebtoonServiceImpl implements WebtoonService {
    WebtoonDataHandler webtoonDataHandler;

    @Autowired
    public WebtoonServiceImpl(WebtoonDataHandler webtoonDataHandler){
        this.webtoonDataHandler = webtoonDataHandler;
    }

    @Override
    public WebtoonDto saveWebtoon(String webtoonId, String webtoonName, String webtoonURL, String webtoonKeyword){
        WebtoonEntity webtoonEntity = webtoonDataHandler.saveWebtoonEntity(webtoonId, webtoonName, webtoonURL, webtoonKeyword);

        WebtoonDto webtoonDto = new WebtoonDto(webtoonEntity.getWebtoonId(),
                webtoonEntity.getWebtoonName(), webtoonEntity.getWebtoonURL(), webtoonEntity.getWebtoonKeyword());

        return webtoonDto;
    }

    @Override
    public WebtoonDto getWebtoon(String webtoonId){
        WebtoonEntity webtoonEntity = webtoonDataHandler.getWebtoonEntity(webtoonId);

        WebtoonDto webtoonDto = new WebtoonDto(webtoonEntity.getWebtoonId(),
                webtoonEntity.getWebtoonName(), webtoonEntity.getWebtoonURL(), webtoonEntity.getWebtoonKeyword());

        return webtoonDto;
    }
}
