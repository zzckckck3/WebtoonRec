package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.Role;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.MemberRepository;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDto memberDto) {
        //암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException{
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(userEmail);
        MemberEntity memberEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin@example.com").equals(userEmail)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(memberEntity.getEmail(), memberEntity.getPassword(), authorities);
    }
}
