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
    private String webtoonAuthor;
    private String webtoonGenre;
    private String webtoonSummary;
    private String webtoonURL;
    private String webtoonThumbnail;
    private String webtoonKeyword;
    private String platform;


    public WebtoonDto( WebtoonEntity entity ){

        this.webtoonId= entity.getWebtoonId();
        this.webtoonName = entity.getWebtoonName();
        this.webtoonAuthor = entity.getWebtoonAuthor();
        this.webtoonGenre = entity.getWebtoonGenre();
        this.webtoonSummary = entity.getWebtoonSummary();
        this.webtoonURL= entity.getWebtoonURL();
        this.webtoonThumbnail = entity.getWebtoonThumbnail();
        this.webtoonKeyword = entity.getWebtoonKeyword();
        this.platform = entity.getPlatform();
    }

    public WebtoonEntity toEntity(){
        return WebtoonEntity.builder()
                .webtoonId(webtoonId)
                .webtoonName(webtoonName)
                .webtoonAuthor(webtoonAuthor)
                .webtoonGenre(webtoonGenre)
                .webtoonSummary(webtoonSummary)
                .webtoonURL(webtoonURL)
                .webtoonThumbnail(webtoonThumbnail)
                .webtoonKeyword(webtoonKeyword)
                .platform(platform)
                .build();
    }
}
