package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    //private Long id;
    private String email;
    private String password;
    private String favWebtoon;
    //private LocalDateTime createdDate;
    //private LocalDateTime modifiedDate;

    public MemberDto(String email, String password, String favWebtoon){
        this.email = email;
        this.password = password;
        this.favWebtoon = favWebtoon;
    }
}
