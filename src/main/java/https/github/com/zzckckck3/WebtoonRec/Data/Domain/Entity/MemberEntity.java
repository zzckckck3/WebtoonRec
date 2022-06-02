package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false) //사실상ID
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = true)
    private String favWebtoon;

    @Enumerated(EnumType.STRING)@Setter
    private RoleType roleType = RoleType.MEMBER;

    public static MemberEntity createMember(String email, String password, String favWebtoon){
        MemberEntity newMember = new MemberEntity();
        newMember.setEmail(email);
        newMember.setPassword(password);
        newMember.setFavWebtoon(favWebtoon);
        newMember.setRoleType(RoleType.MEMBER);

        return newMember;
    }

    public void Encodedpassword(PasswordEncoder encoder) {
        this.password= encoder.encode(this.password);
    }
}
