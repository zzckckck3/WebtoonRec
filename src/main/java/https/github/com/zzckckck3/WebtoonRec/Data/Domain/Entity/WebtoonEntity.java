package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity;

import https.github.com.zzckckck3.WebtoonRec.Data.Dto.WebtoonDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString // 여기까지 == @Data
@Table(name = "webtoon")
public class WebtoonEntity {
    @Id //한 테이블당 하나의 primary key가 필요한데, 자바에서는 Id를 부여해서 생성해준다
    String webtoonId; //PK

    private String webtoonName;
    private String webtoonAuthor;
    private String webtoonGenre;
    private String webtoonSummary;
    private String webtoonURL;
    private String webtoonThumbnail;
    private String webtoonKeyword;
    private String platform;
    /*
    @Column

    @Column
    */

    public WebtoonDto toDto(){
        return WebtoonDto.builder()
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
