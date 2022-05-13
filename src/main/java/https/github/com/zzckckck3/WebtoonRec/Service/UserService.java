package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.UserEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserEntity userEntity){
        return userRepository.save(userEntity).getId();
    }
}
