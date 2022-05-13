package https.github.com.zzckckck3.WebtoonRec.Controller.ApiController;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.UserDto;
import https.github.com.zzckckck3.WebtoonRec.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/vi/user")
    public Long save(@RequestBody UserDto userDto){
        return userService.save(userDto.toEntity());
    }
}
