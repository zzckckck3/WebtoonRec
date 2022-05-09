package https.github.com.zzckckck3.WebtoonRec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration{
    private static final String API_NAME = "WebtoonRec Spring Boot REST API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "WebtoonRec Rest API";

    @Bean
    public Docket api(){
        /*Parameter parameterBuilder = new ParameterBuilder().name(HttpHeaders.AUTHORIZATION)
                .description("Access Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        List<Parameter> globalParameters = new ArrayList<>();
        globalParameters.add(parameterBuilder);*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("https.github.com.zzckckck3.WebtoonRec"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION)
                .build();
    }
}
