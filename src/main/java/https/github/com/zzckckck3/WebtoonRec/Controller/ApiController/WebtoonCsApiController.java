package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;
import https.github.com.zzckckck3.WebtoonRec.Service.Impl.WebtoonService2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/webtoon-api")
public class WebtoonCsApiController {
    private final WebtoonService2 webtoonService2;

    @GetMapping("/webtoon/all")
    public List<WebtoonDto> findAllbyCs(@RequestParam int offset, @RequestParam int limit){
        List<WebtoonEntity> datas = webtoonService2.findAll( offset , limit );
        System.out.println( datas.get( 0 ).getWebtoonSummary());
        List<WebtoonDto> dtoList = datas.stream().map( WebtoonDto::new ).collect(Collectors.toList());
        return dtoList;
    }

    @GetMapping("/webtoon/allkeyword")
    public List<WebtoonDto> findAllbykeyword(@RequestParam String keyword,@RequestParam int limit){
        List<WebtoonEntity> datas = webtoonService2.findAll2();
        List<WebtoonEntity> ClusteredDatas = datas.stream().filter( webtoonEntity -> webtoonEntity.getWebtoonKeyword().contains( keyword ) ).collect(Collectors.toList());

        List<WebtoonDto> dtoList = ClusteredDatas.stream().map( WebtoonDto::new ).collect(Collectors.toList());
        return dtoList;
    }

    @GetMapping("/webtoon/allname")
    public List<WebtoonDto> findAllbyName(@RequestParam String name, @RequestParam int limit){
        List<WebtoonEntity> datas = webtoonService2.findAll2();
        List<WebtoonEntity> ClusteredDatas = datas.stream().filter( webtoonEntity -> webtoonEntity.getWebtoonName().contains( name ) ).collect(Collectors.toList());

        List<WebtoonDto> dtoList = ClusteredDatas.stream().map( WebtoonDto::new ).collect(Collectors.toList());
        return dtoList;
    }

    @GetMapping("/webtoon/allplatform")
    public List<WebtoonDto> findAllbyPlatform(@RequestParam String platform, @RequestParam int limit, @RequestParam int offset){
        List<WebtoonEntity> datas = webtoonService2.findbyPlatform( platform, offset, limit);
        //List<WebtoonEntity> ClusteredDatas = datas.stream().filter( webtoonEntity -> webtoonEntity.getPlatform().contains( platform ) ).collect(Collectors.toList());
        //List<WebtoonDto> dtoList = ClusteredDatas.stream().map( WebtoonDto::new ).collect(Collectors.toList());
        List<WebtoonDto> dtoList = datas.stream().map(WebtoonDto::new).collect(Collectors.toList());
        return dtoList;
    }

    @GetMapping("/webtoon/single/{webtoonId}")
    public WebtoonEntity getItembyId(@PathVariable String webtoonId){
        WebtoonEntity webtoonEntity = webtoonService2.findOne(webtoonId);

        return webtoonService2.findOne(webtoonId);
    }
}
