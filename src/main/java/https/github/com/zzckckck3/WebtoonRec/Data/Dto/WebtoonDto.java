package https.github.com.zzckckck3.WebtoonRec.Data.Dto;

import https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity.WebtoonEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WebtoonDto {
    private String webtoonId;
    private String webtoonName;
    private String webtoonURL;
    private String webtoonKeyword;

    public WebtoonEntity toEntity(){
        return WebtoonEntity.builder()
                .webtoonId(webtoonId)
                .webtoonName(webtoonName)
                .webtoonURL(webtoonURL)
                .webtoonKeyword(webtoonKeyword)
                .build();
    }
}
