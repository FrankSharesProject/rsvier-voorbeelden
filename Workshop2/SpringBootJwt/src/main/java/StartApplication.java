

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"features"})
@ComponentScan(basePackages={"features", "security"}) //Package 'security' moet in de ComponentScan staan, zodat de WebSecurityConfig gevonden wordt
@EntityScan(basePackages={"features"})
public class StartApplication extends SpringBootServletInitializer{
    private static Logger log = LoggerFactory.getLogger(StartApplication.class);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }

    public static void main(String[] args) {
        log.debug("Starting app...");
        SpringApplication.run(StartApplication.class, args);
    }
        
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

}
