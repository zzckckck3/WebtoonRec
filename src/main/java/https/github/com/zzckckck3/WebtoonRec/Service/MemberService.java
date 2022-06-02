package https.github.com.zzckckck3.WebtoonRec.Service;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.MemberCsRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberCsRepository memberCsRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final EntityManager em;

    //sign-up
    @Transactional
    public Long save(MemberEntity memberEntity){
        memberEntity.Encodedpassword(passwordEncoder);
        Long saveid = memberCsRepository.save(memberEntity);
        return saveid;
    }

    public List<MemberEntity> findAll(int offset, int limit){
        return memberCsRepository.findAll(offset, limit);
    }

    @Override //login
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        MemberEntity memberEntity = memberCsRepository.findByEmail(email);
        System.out.println(memberEntity.getRoleType());
        if(memberEntity==null){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRoleType().toString())
                .build();
    }

    public PasswordEncoder getPasswordEncoder(){
        return passwordEncoder;
    }

    public MemberEntity findByEmail(String email){
        return memberCsRepository.findByEmail(email);
    }


    public void addfavWebtoon(String webtoonId, String email) throws Exception {
        memberRepository.plus(webtoonId, email);
    }
}
