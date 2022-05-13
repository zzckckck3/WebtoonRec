package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.Role;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(Role.USER)
                .build();
    }
}
