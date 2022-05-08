/*package https.github.com.zzckckck3.WebtoonRec.Domain.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Member implements MemberDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Member_ID;

    @Column(name = "user_ID", nullable = false)
    private String user_ID;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "role", nullable = false)
    private String role;
}
*/