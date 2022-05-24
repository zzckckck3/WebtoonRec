package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "/fragments/public/memJoin";
    }

    //회원가입 처리
    @PostMapping("/user/signup-proc")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }
    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/fragments/public/memLogin";
    }

    // 로그인 결과 페이지
    /*@GetMapping("/")
    public String dispLoginResult() {
        return "/fragments/public/home";
    }*/

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
