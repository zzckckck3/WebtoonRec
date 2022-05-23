package https.github.com.zzckckck3.WebtoonRec.Controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    public String hello(){
        return "Hello world!";
    }

    @PostMapping("log-test")
    public void logTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info log");
        LOGGER.warn("Warn log");
        LOGGER.error("Error log");
    }
}
