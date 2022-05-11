package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import lombok.*;

import javax.management.relation.Role;

//@Data //대부분의 속성들을 퉁칠 수 있다. 하지만 불필요한 메서드가 추가되기에 기피됨
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
    private String username;
    private String password;
    private String email;
    private String name;
    private String gender;
    private String favGenre;
    private String exGenre;
    private Role roleType;

    /*
    //아래 코드들은 어노테이션으로 생략할 수 있다.(Getter, Setter, ToString)
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }*/
}
