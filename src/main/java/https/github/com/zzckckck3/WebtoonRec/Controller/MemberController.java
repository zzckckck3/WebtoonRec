package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "/fragments/public/memJoin";
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

    // 접근 거부 페이지
    /*
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }
    */

    // 내 정보 페이지
    /*
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }
     */

    // 어드민 페이지
    /*
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
     */
}
