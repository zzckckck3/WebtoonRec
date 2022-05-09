package https.github.com.zzckckck3.WebtoonRec.Data.Handler;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;

public interface WebtoonDataHandler {
    WebtoonEntity saveWebtoonEntity(String webtoonId, String webtoonName, String webtoonURL, String webtoonKeyword);

    WebtoonEntity getWebtoonEntity(String webtoonId);
}
