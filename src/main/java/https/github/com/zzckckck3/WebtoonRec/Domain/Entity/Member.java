package https.github.com.zzckckck3.WebtoonRec.Domain.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name="MEMBER")
public class Member {

    @Column(name = "member_id", nullable = false)
    @Setter
    @Id @GeneratedValue
    private Long Member_ID;

    @Setter @Column(nullable = false)
    private String user_ID;
    @Column(name = "pwd", nullable = false)@Setter
    private String pwd;
    @Column(name = "NAME", nullable = false, length = 20)@Setter
    private String Name;

    /*
    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Orders> ordersList
    @Enumerated(EnumType.STRING)@Setter
    private MemberRoleType roleType = MemberRoleType.User;
    */
    @Column(name = "RegDate")@Setter
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate date;

    public static Member createMember(String id, String name, String pwd) {
        Member newMember = new Member();
        newMember.setUser_ID(id);
        newMember.setName(name);
        newMember.setPwd(pwd);
        newMember.setRoleType(MemberRoleType.USER);
        newMember.setDate(LocalDate.now());
        return newMember;
    }
    public void Encodepwd(PasswordEncoder encoder){
        this.pwd=encoder.encode(this.pwd);
    }
}
