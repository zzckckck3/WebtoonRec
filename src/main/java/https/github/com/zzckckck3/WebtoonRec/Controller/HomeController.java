package https.github.com.zzckckck3.WebtoonRec.Controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "/fragments/public/home";
    }

    @GetMapping("/search/{keyword}")
    public String search(@PathVariable @Nullable String keyword){
        return "fragments/public/homeSearch";
    }

    @GetMapping("/keysearch/{keyword}")
    public String keysearch(@PathVariable @Nullable String keyword){
        return "fragments/public/homeKeySearch";
    }
}