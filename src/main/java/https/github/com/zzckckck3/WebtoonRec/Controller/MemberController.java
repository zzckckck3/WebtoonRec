package https.github.com.zzckckck3.WebtoonRec.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @RequestMapping("member/memJoin")
    String join(){
        return "/fragments/public/memJoin";
    }
}
