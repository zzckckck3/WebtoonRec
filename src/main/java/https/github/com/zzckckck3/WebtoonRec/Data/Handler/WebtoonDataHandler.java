package https.github.com.zzckckck3.WebtoonRec.Data.Handler;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;

import java.util.List;

public interface WebtoonDataHandler {
    WebtoonEntity saveWebtoonEntity(String webtoonId, String webtoonName, String webtoonAuthor, String webtoonGenre, String webtoonSummary,
                                    String webtoonURL, String webtoonThumbnail, String webtoonKeyword, String platform);

    WebtoonEntity getWebtoonEntity(String webtoonId);

    List<WebtoonEntity> getWebtoonEntityAll();
}
