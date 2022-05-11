package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;

public interface WebtoonService { //인터페이스와 class를 찢어놓는것이 루즈커플링이라는 것이다 >> 결합되는 Controller, Service, Class 각 객체들 간의 의존성을 줄여주는 것
    WebtoonDto saveWebtoon(String webtoonId, String webtoonName, String webtoonAuthor, String webtoonGenre, String webtoonSummary,
                           String webtoonURL, String webtoonThumbnail, String webtoonKeyword);
    //webtoonId,webtoonName,webtoonAuthor,webtoonGenre,webtoonSummary,webtoonURL,webtoonThumbnail,webtoonKeyword
    WebtoonDto getWebtoon(String webtoonId);
}
