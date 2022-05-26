package https.github.com.zzckckck3.WebtoonRec.Service.Impl;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.WebtoonCsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebtoonService2 {
    private final WebtoonCsRepository csRepository;

    public List<WebtoonEntity> findAll( int offset, int limit ){
        return csRepository.findAll( offset, limit );
    }

    public List<WebtoonEntity> findAllwithKeyword( String keyword ){
        return csRepository.findAllwithKeyword( keyword );
    }

    public List<WebtoonEntity> findAllwithName( String name ){
        return csRepository.findAllwithName(name);
    }

    public WebtoonEntity findOne (String id) {
        return csRepository.findWebtoon(id);
    }


    public List<WebtoonEntity> findAll2( ){
        return csRepository.findAlll();
    }

}
