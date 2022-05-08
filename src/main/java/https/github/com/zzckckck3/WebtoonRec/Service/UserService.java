package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Domain.Entity.Userinfo;
import https.github.com.zzckckck3.WebtoonRec.Domain.Repository.UserinfoRepository;
import https.github.com.zzckckck3.WebtoonRec.Dto.UserinfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserinfoRepository userinfoRepository;
    /*
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public Userinfo loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userinfoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    /*
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public Long save(UserinfoDto userinfoDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userinfoDto.setPassword(encoder.encode(userinfoDto.getPassword()));

        return userinfoRepository.save(Userinfo.builder()

                .email(userinfoDto.getEmail())
                .auth(userinfoDto.getAuth())
                .password(userinfoDto.getPassword()).build()).getCode();

    }
}
