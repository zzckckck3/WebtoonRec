package https.github.com.zzckckck3.WebtoonRec.Controller;

import org.springframework.web.bind.annotation.*;

@RestController // 주소 부여
public class HomeControllerTest {
    @GetMapping("/test")
    public String test(){
        return "<h1>hello spring boot<h1>";
    }

    @RequestMapping(path="/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }
}
