package junia.projet.web.config;

import com.shieldsolutions.velocity.view.VelocityConfigurer;
import com.shieldsolutions.velocity.view.VelocityViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "junia.projet.web.controller")

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        VelocityConfigurer velocityConfigurer= new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity");
        return velocityConfigurer;};

    @Bean
    public VelocityViewResolver velocityViewResolver(){
        VelocityViewResolver velocityViewResolver=new VelocityViewResolver();
        velocityViewResolver.setSuffix(".vm");
        return velocityViewResolver;};

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //login n'a pas de controller pour l'intercepter donc il faut configurer ici le lancement du template
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/login").setViewName("login");
    }
}