package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.MemberEntity;
import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.RoleType;

public class MemberUpdateDto {
    private Long id;
    private String email;
    private RoleType roleType;
    private String favWebtoon;

    public MemberUpdateDto(MemberEntity memberEntity){
        this.id = memberEntity.getId();
        this.email = memberEntity.getEmail();
        this.roleType = memberEntity.getRoleType();
        this.favWebtoon = memberEntity.getFavWebtoon();
    }
}