package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

/*
@RestController
@RequestMapping("/api/v1/webtoon-api")
@Slf4j
public class WebtoonApiController {
    private final Logger LOGGER = LoggerFactory.getLogger(WebtoonApiController.class);
    private WebtoonServiceImpl webtoonService;

    @Autowired
    public WebtoonApiController(WebtoonServiceImpl webtoonService){
        this.webtoonService = webtoonService;
    }

    @GetMapping(value = "/webtoon/{webtoonId}")
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
        String platform = webtoonDto.getPlatform();

        return webtoonService.saveWebtoon(webtoonId,webtoonName,webtoonAuthor,webtoonGenre,webtoonSummary,webtoonURL,webtoonThumbnail,webtoonKeyword, platform);
    }


    @DeleteMapping(value = "/webtoon/{webtoonId}") //사용할일은 거의 없을 듯 하지만 일단 구현
    public WebtoonDto deleteWebtoon(@PathVariable Long webtoonId){
        return null;
    }



}


 */