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

    String webtoonName;
    String webtoonURL;
    String webtoonKeyword;

    /*
    @Column

    @Column
    */

    public WebtoonDto toDto(){
        return WebtoonDto.builder()
                .webtoonId(webtoonId)
                .webtoonName(webtoonName)
                .webtoonURL(webtoonURL)
                .webtoonKeyword(webtoonKeyword)
                .build();
    }
}
