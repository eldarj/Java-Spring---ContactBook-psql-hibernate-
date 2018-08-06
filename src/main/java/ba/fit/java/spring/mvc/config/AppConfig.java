package ba.fit.java.spring.mvc.config;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "ba.fit.java.spring.mvc") // Set base package for all components
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class};
    } // define root config

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    } // define mvcconfig

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    } // map servlet /controllers to this
}
