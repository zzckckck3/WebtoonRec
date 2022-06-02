package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.FavWebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.FavWebtoonCsRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.FavWebtoonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FavWebtoonService {
    private final FavWebtoonCsRepository favWebtoonCsRepository;
    private final FavWebtoonRepository favWebtoonRepository;
    private final EntityManager em;

    @Transactional
    public Long save(FavWebtoonEntity favWebtoonEntity){
        Long saveid = favWebtoonCsRepository.save(favWebtoonEntity);
        return saveid;
    }

    public List<FavWebtoonEntity> findAll(){
        return favWebtoonCsRepository.findAll();
    }

    public List<FavWebtoonEntity> findAllbyEmail(String email){
        return favWebtoonCsRepository.findAllbyEmail(email);
    }

    @Transactional
    public void deleteFavWebtoon(String webtoonId, String memberEmail) throws Exception{
        favWebtoonRepository.del(webtoonId, memberEmail);
    }
}
