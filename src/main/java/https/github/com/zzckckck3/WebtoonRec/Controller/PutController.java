package https.github.com.zzckckck3.WebtoonRec.Controller;

import https.github.com.zzckckck3.WebtoonRec.Dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value = "/default")
    public String putMethod(){
        return "Hello";
    }

    @PutMapping(value = "member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n"); //map에 있는 데이터를 한번씩 까본다
        });

        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    } //memberDTO를 받아 바로 String으로 뿌려주는 방식

    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    } //memberDTO자체를 받아오는 방식 >> json형태로 받아오기 때문에 이를 사용하는 것이 좋겠다.

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    } //memberDTO를 받고, ResponseEntity를 씌워서 status를 Accepted를 씌워 body값에 memberDTO를 받아 return
    //return의 code가 변경된다  >>  ACCEPTED => 202
}
