package https.github.com.zzckckck3.WebtoonRec.Data.Dao;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;

public interface WebtoonDao {
    WebtoonEntity saveWebtoon(WebtoonEntity webtoonEntity);
    WebtoonEntity getWebtoon(String webtoonId);
}
