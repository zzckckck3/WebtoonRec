package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Dto.UserinfoDto;
import https.github.com.zzckckck3.WebtoonRec.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    @PostMapping("/user")
    public String join(UserinfoDto userinfoDto){
        userService.save(userinfoDto);
        return "redirect:/memLogin";
    }
}
