package spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Created by srinathmedala on 5/16/15.
 */

@Configuration
@EnableSwagger
@EnableWebMvc
@ComponentScan("spring.*")
@PropertySource("classpath:swagger.properties")
@Import(SpringSwaggerConfig.class)
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/*.*");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("My Project's REST API", "This is a description of your API.", "API TOS",
                "naivegeek@gmail.com", "API License", "API License URL");
        return apiInfo;
    }
}
