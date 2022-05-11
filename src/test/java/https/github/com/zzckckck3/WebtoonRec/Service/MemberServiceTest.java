package https.github.com.zzckckck3.WebtoonRec.Service;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public MemberEntity createMember(){
        MemberDto memberDto = new MemberDto();
        memberDto.setUsername("zzckxkckTest");
        memberDto.setPassword("1234");
        memberDto.setEmail("test@gmail.com");
        memberDto.setName("이재진");
        memberDto.setGender("남");
        memberDto.setFavGenre("무협");
        memberDto.setExGenre("BL");

        return MemberEntity.createMember(memberDto, passwordEncoder);
    }

    @Test
    @DisplayName("Join Test")
    public void saveMemberTest() {
        MemberEntity memberEntity = createMember();
        MemberEntity savedMember = memberService.saveMember(memberEntity);

        assertEquals(memberEntity.getUsername(), savedMember.getUsername());
        assertEquals(memberEntity.getPassword(), savedMember.getPassword());
        assertEquals(memberEntity.getEmail(), savedMember.getEmail());
        assertEquals(memberEntity.getName(), savedMember.getName());
        assertEquals(memberEntity.getGender(), savedMember.getGender());
        assertEquals(memberEntity.getFavGenre(), savedMember.getFavGenre());
        assertEquals(memberEntity.getExGenre(), savedMember.getExGenre());
        assertEquals(memberEntity.getRoleType(), savedMember.getRoleType());
    }
}