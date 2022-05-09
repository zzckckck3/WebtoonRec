package https.github.com.zzckckck3.WebtoonRec.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("hello")
    public String hello(){
        return "Hello world!";
    }
}
