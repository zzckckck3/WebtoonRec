package https.github.com.zzckckck3.WebtoonRec.Domain;

import lombok.*;

import javax.persistence.*;

@Entity //table > 인스턴트들이 jpa로 관리되는 엔티티 객체라는 것을 의미
@Table(name = "firstDomain") // Entity와 같이 사용 > DB상에서 엔티티 클래스를 어떤 테이블로 생성할 건지에 대한 정보 담기 위함
@Getter //~get 자동 설정
@Setter //~set 자동 설정
public class TestDB {
    @Id //Entity가 붙은 클래스는 PK에 해당하는 특정 필드를 @Id로 지정해야한다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB seq에 자동 ID 삽입
    //auto = 내가 사용하는 sql에서 기본으로 지원하는 것을 사용
    //identity = hibernate seq > db seq가 상당히 많을 떄 사용
    //sequence = DB seq을 사용 > 서버 자체에 들어가는 비중이 클 떄 사용
    private Long Id;
    private String main;
}
