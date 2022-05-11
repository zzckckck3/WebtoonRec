package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;
import https.github.com.zzckckck3.WebtoonRec.Service.Impl.WebtoonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/webtoon-api")
@Slf4j
public class WebtoonController {
    private final Logger LOGGER = LoggerFactory.getLogger(WebtoonController.class);
    private WebtoonServiceImpl webtoonService;

    @Autowired
    public WebtoonController(WebtoonServiceImpl webtoonService){
        this.webtoonService = webtoonService;
    }

    @GetMapping(value = "/webtoon/{webtoonID}")
    public WebtoonDto getWebtoon(@PathVariable String webtoonId){
        LOGGER.info("[WebtoonController] perform {} of Webtoon Rec API", "getWebtoon");

        WebtoonDto webtoonDto = webtoonService.getWebtoon(webtoonId);

        LOGGER.info("[WebtoonController] Response :: webtoonId = {}", webtoonId);
        return webtoonService.getWebtoon(webtoonId);
    }

    @PostMapping(value = "/webtoon")
    public WebtoonDto createWebtoon(@RequestBody WebtoonDto webtoonDto){ //A를 받아 A를 뱉어주는 형식
        String webtoonId = webtoonDto.getWebtoonId();
        String webtoonName = webtoonDto.getWebtoonName();
        String webtoonAuthor = webtoonDto.getWebtoonAuthor();
        String webtoonGenre = webtoonDto.getWebtoonGenre();
        String webtoonSummary = webtoonDto.getWebtoonSummary();
        String webtoonURL = webtoonDto.getWebtoonURL();
        String webtoonThumbnail = webtoonDto.getWebtoonThumbnail();
        String webtoonKeyword = webtoonDto.getWebtoonKeyword();

        return webtoonService.saveWebtoon(webtoonId,webtoonName,webtoonAuthor,webtoonGenre,webtoonSummary,webtoonURL,webtoonThumbnail,webtoonKeyword);
    }

    @DeleteMapping(value = "/webtoon/{webtoonId}") //사용할일은 거의 없을 듯 하지만 일단 구현
    public WebtoonDto deleteWebtoon(@PathVariable String webtoonId){
        return null;
    }
}
