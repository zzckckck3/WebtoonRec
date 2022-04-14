package https.github.com.zzckckck3.WebtoonRec.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter //~get 자동 설정
@Setter //~set 자동 설정
@Entity //table
@Table(name = "firstDomain")
public class TestDB {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB seq에 자동 ID 삽입
    //auto = 내가 사용하는 sql에서 기본으로 지원하는 것을 사용
    //identity = hibernate seq > db seq가 상당히 많을 떄 사용
    //sequence = DB seq을 사용 > 서버 자체에 들어가는 비중이 클 떄 사용
    private Long Id;
    private String main;
}
