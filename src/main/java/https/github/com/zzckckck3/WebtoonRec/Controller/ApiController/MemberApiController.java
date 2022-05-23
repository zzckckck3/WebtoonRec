package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberApiController {
    private final MemberService memberService;

    @Autowired
    public MemberApiController(MemberService memberService){
        this.memberService = memberService;
    }
}
