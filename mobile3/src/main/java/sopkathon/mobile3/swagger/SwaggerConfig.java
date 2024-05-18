package sopkathon.mobile3.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To.0(가제) Project API")
                        .description("서로에 대한 사전 정보를 퀴즈라는 게임식 형태로, 미리 제공함으로써 첫 대화를 수월하게 도와주는 서비스를 제공합니다")
                        .version("1.0.0"));
    }
}