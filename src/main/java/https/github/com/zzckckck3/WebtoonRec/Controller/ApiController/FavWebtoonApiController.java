package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.FavWebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.FavWebtoonCsRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.FavWebtoonRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.FavWebtoonDto;
import https.github.com.zzckckck3.WebtoonRec.Service.FavWebtoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/favWebtoon-api")
public class FavWebtoonApiController {
    private final FavWebtoonService favWebtoonService;
    private final FavWebtoonCsRepository favWebtoonCsRepository;
    private final FavWebtoonRepository favWebtoonRepository;

    /*FavWebtoonApiController(@Lazy FavWebtoonService favWebtoonService, @Lazy FavWebtoonCsRepository favWebtoonCsRepository){
        this.favWebtoonService = favWebtoonService;
        this.favWebtoonCsRepository = favWebtoonCsRepository;
    }*/

    /*@GetMapping("/all")
    public List<FavWebtoonDto> findAllbyEmail(@RequestParam String email){
        List<FavWebtoonEntity> datas = favWebtoonService.findAllbyEmail(email);
        List<FavWebtoonDto> dtoList = datas.stream().map( FavWebtoonDto::new ).collect(Collectors.toList());
        return dtoList;
    }*/

    @GetMapping("/allbyEmail")
    public List<FavWebtoonDto> findallbyEmail(@RequestParam String email) {
        List<FavWebtoonEntity> datas = favWebtoonService.findAll();
        List<FavWebtoonEntity> ClusteredDatas = datas.stream().filter(favWebtoonEntity ->
                favWebtoonEntity.getMemberEmail().contains(email)).collect(Collectors.toList());

        List<FavWebtoonDto> dtoList = ClusteredDatas.stream().map(FavWebtoonDto::new).collect(Collectors.toList());
        return dtoList;
    }


    @PostMapping("/addfav")
    public void post(@Valid FavWebtoonDto favWebtoonDto){
        FavWebtoonEntity favWebtoonEntity = FavWebtoonEntity.createFav(favWebtoonDto.getMemberEmail(), favWebtoonDto.getWebtoonId());
        favWebtoonService.save(favWebtoonEntity);

        return;
    }

    @DeleteMapping("/delfav")
    void del(@RequestParam String webtoonId, @RequestParam String memberEmail) throws Exception{
        favWebtoonService.deleteFavWebtoon(webtoonId, memberEmail);
    }
}
