package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Repository.CustomRepo.MemberCsRepository;
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
    private final MemberCsRepository memberCsRepository;

    MemberApiController (@Lazy MemberService memberService, @Lazy MemberCsRepository memberCsRepository){
        this.memberService = memberService;
        this.memberCsRepository = memberCsRepository;
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



    /*
    @PutMapping("/puttest")
    public void put(@RequestParam String webtoonId, @RequestParam String email){
        memberService.plus(webtoonId, email);
        System.out.println(webtoonId);
        System.out.println(email);
    }
     */
    /*
    @PutMapping("/puttest")
    public List<MemberEntity> put(){
        return memberService.addfavWebtoon("3", "zzckxkck1@gmail.com");
    }
     */
}
