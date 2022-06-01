package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@Slf4j
//@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    MemberController (@Lazy MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "/fragments/public/memJoin";
    }

    //회원가입 처리
    @PostMapping("/user/signup-proc")
    public String execSignup(@Valid MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.createMember(memberDto.getEmail(), memberDto.getPassword(), memberDto.getFavWebtoon());
        System.out.println("===========");
        System.out.println(memberDto);
        System.out.println(memberEntity);
        System.out.println(memberService);
        System.out.println("===========");
        memberService.save(memberEntity);
        return "/fragments/public/memJoinSuccess";
    }


    // 로그인 페이지
    @GetMapping("/user/login")
    public String login(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        return "/fragments/public/memLogin";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    @PutMapping("/puttest")
    public void putTest(){
        System.out.println("test");

    }

}

