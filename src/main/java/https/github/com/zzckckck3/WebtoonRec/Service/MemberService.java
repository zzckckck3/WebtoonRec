package https.github.com.zzckckck3.WebtoonRec.Service;


import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.MemberCsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberCsRepository memberCsRepository;
    private final PasswordEncoder passwordEncoder;

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

}
