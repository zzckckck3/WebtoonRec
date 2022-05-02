package https.github.com.zzckckck3.WebtoonRec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WebtoonRecApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtoonRecApplication.class, args );

	}

}
