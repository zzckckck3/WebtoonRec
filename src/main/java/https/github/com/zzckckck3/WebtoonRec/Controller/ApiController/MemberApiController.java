package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member-api")
public class MemberApiController {
    private final MemberService memberService;

    //회원가입 처리
    @PostMapping("/signup-proc")
    public boolean execSignup(@Valid @RequestBody MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.createMember(memberDto.getEmail(), memberDto.getPassword(), memberDto.getFavWebtoon());
        memberService.save(memberEntity);

        return true;
    }

    //@GetMapping("/members/all")
}
