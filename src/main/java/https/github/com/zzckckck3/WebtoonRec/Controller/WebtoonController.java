package https.github.com.zzckckck3.WebtoonRec.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class WebtoonController {
    @GetMapping("/webtoon/{webtoonId}")
    public String getWebtoonPage(@PathVariable String webtoonId){
        return "fragments/public/webtooninfo";
    }
}