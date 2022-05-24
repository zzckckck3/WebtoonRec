package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String favWebtoon;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .favWebtoon(favWebtoon)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
        this.favWebtoon = favWebtoon;
    }
}
