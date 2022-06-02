package https.github.com.zzckckck3.WebtoonRec.Data.Domain.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "favWebtoon")
public class FavWebtoonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String webtoonId;

    public static FavWebtoonEntity createFav(String memberEmail, String webtoonId){
        FavWebtoonEntity newFavWebtoon = new FavWebtoonEntity();
        newFavWebtoon.setMemberEmail(memberEmail);
        newFavWebtoon.setWebtoonId(webtoonId);

        return newFavWebtoon;
    }
}
