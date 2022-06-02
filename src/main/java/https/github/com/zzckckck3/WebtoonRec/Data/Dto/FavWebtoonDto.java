package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.FavWebtoonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FavWebtoonDto {
    private String memberEmail;
    private String webtoonId;

    public FavWebtoonDto(String memberEmail, String webtoonId){
        this.memberEmail = memberEmail;
        this.webtoonId = webtoonId;
    }

    public FavWebtoonDto(FavWebtoonEntity favWebtoonEntity) {
        this.memberEmail = favWebtoonEntity.getMemberEmail();
        this.webtoonId = favWebtoonEntity.getWebtoonId();
    }
}
