package https.github.com.zzckckck3.WebtoonRec.Service.Impl;

/*
@Service
public class WebtoonServiceImpl implements WebtoonService {
    WebtoonDataHandler webtoonDataHandler;
    WebtoonRepository webtoonRepository;


    @Autowired
    public WebtoonServiceImpl(WebtoonDataHandler webtoonDataHandler){
        this.webtoonDataHandler = webtoonDataHandler;
    }



    @Override
    public WebtoonDto saveWebtoon(String id, String webtoonId, String webtoonName, String webtoonAuthor, String webtoonGenre, String webtoonSummary, String webtoonURL, String webtoonThumbnail, String webtoonKeyword, String platform) {
        return null;
    }

    @Override
    public WebtoonDto saveWebtoon(String webtoonId, String webtoonName, String webtoonAuthor, String webtoonGenre, String webtoonSummary,
                                  String webtoonURL, String webtoonThumbnail, String webtoonKeyword, String platform){
        WebtoonEntity webtoonEntity = webtoonDataHandler.saveWebtoonEntity(webtoonId, webtoonName, webtoonAuthor, webtoonGenre, webtoonSummary,
                webtoonURL, webtoonThumbnail, webtoonKeyword, platform);

        WebtoonDto webtoonDto = new WebtoonDto(webtoonEntity.getWebtoonId(),
                webtoonEntity.getWebtoonName(), webtoonEntity.getWebtoonAuthor(), webtoonEntity.getWebtoonGenre(),
                webtoonEntity.getWebtoonSummary(),webtoonEntity.getWebtoonURL(), webtoonEntity.getWebtoonThumbnail(),
                webtoonEntity.getWebtoonKeyword(), webtoonEntity.getPlatform());


        WebtoonDto webtoonDto = new WebtoonDto( webtoonEntity );
        return webtoonDto;
    }


    @Override
    public WebtoonDto getWebtoon(String webtoonId){
        WebtoonEntity webtoonEntity = webtoonDataHandler.getWebtoonEntity(webtoonId);

        WebtoonDto webtoonDto = new WebtoonDto(webtoonEntity.getWebtoonId(),
                webtoonEntity.getWebtoonName(), webtoonEntity.getWebtoonAuthor(), webtoonEntity.getWebtoonGenre(),
                webtoonEntity.getWebtoonSummary(),webtoonEntity.getWebtoonURL(), webtoonEntity.getWebtoonThumbnail(),
                webtoonEntity.getWebtoonKeyword(), webtoonEntity.getPlatform());


        WebtoonDto webtoonDto = new WebtoonDto( webtoonEntity );
        return webtoonDto;
    }

    public WebtoonDto getAllWebtoon(){
        List<WebtoonEntity> webtoonEntity = webtoonDataHandler.getWebtoonEntityAll();
        return null;
    }


}

*/