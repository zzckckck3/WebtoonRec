package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberEntity saveMember(MemberEntity memberEntity){
        validateDuplicateMebmer(memberEntity);
        return memberRepository.save(memberEntity);
    }

    private void validateDuplicateMebmer(MemberEntity memberEntity){
        MemberEntity findMember = memberRepository.findByEmail(memberEntity.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
