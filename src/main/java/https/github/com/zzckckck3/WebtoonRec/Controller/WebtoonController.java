package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;
import https.github.com.zzckckck3.WebtoonRec.Service.Impl.WebtoonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/webtoon-api")
public class WebtoonController {
    private WebtoonServiceImpl webtoonService;

    @Autowired
    public WebtoonController(WebtoonServiceImpl webtoonService){
        this.webtoonService = webtoonService;
    }

    @GetMapping(value = "/webtoon/{webtoonID}")
    public WebtoonDto getWebtoon(@PathVariable String webtoonId){
        return webtoonService.getWebtoon(webtoonId);
    }

    @PostMapping(value = "/webtoon")
    public WebtoonDto createWebtoon(@RequestBody WebtoonDto webtoonDto){ //A를 받아 A를 뱉어주는 형식
        String webtoonId = webtoonDto.getWebtoonId();
        String webtoonName = webtoonDto.getWebtoonName();
        String webtoonURL = webtoonDto.getWebtoonURL();
        String webtoonKeyword = webtoonDto.getWebtoonKeyword();

        return webtoonService.saveWebtoon(webtoonId,webtoonName,webtoonURL,webtoonKeyword);
    }

    @DeleteMapping(value = "/webtoon/{webtoonId}") //사용할일은 거의 없을 듯 하지만 일단 구현
    public WebtoonDto deleteWebtoon(@PathVariable String webtoonId){
        return null;
    }
}
