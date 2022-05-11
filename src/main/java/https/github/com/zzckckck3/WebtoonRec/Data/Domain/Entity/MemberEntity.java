package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "member")
public class MemberEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userIdx;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "favGenre")
    private String favGenre;

    @Column(name = "exGenre")
    private String exGenre;

    @Column(name = "roleType")
    @Enumerated(EnumType.STRING)
    private roleType roleType;

    public static MemberEntity createMember
            (MemberDto memberDto, PasswordEncoder passwordEncoder){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberEntity.getUsername());
        //member.setPassword(member.getPassword()); >> security적용
        String password = passwordEncoder.encode(memberDto.getPassword());
        memberEntity.setEmail(memberEntity.getEmail());
        memberEntity.setName(memberEntity.getName());
        memberEntity.setGender(memberEntity.getGender());
        memberEntity.setFavGenre(memberEntity.getFavGenre());
        memberEntity.setExGenre(memberEntity.getExGenre());
        memberEntity.setRoleType(https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.roleType.USER);
        //왜자꾸 import짤리고 여기로 오는거임?

        return memberEntity;
    }
}
