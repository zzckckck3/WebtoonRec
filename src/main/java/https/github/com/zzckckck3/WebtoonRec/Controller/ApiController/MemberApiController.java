package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
//@RequiredArgsConstructor
@RequestMapping("api/v2/member-api")
public class MemberApiController {
    private final MemberService memberService;

    MemberApiController (@Lazy MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/session")
    public String getsession(Principal principal) {
        System.out.println(principal.getName());
        String loginMember = new String(principal.getName());
        return loginMember;
    }

    @GetMapping("/gettest")
    public MemberEntity returnJ(){
        return memberService.findByEmail("zzckxkck1@gmail.com");
    }

    //@GetMapping("/members/all")
}
