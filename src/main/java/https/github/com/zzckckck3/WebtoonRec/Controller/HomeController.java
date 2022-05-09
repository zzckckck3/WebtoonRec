package https.github.com.zzckckck3.WebtoonRec.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("username", "testUsername");
        return "/fragments/public/home";
    }
}