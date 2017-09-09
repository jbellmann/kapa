package de.jbellmann.kapapa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig {

    private static final String[] APP_CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/app/",
            "classpath:/resources/app/", "classpath:/static/app/", "classpath:/public/app/" };

    private static final String[] ADMIN_CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/admin/",
            "classpath:/resources/admin/", "classpath:/static/admin/", "classpath:/public/admin/" };

    @Bean
    public WebMvcConfigurer viewControllers() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/app").setViewName("app/index");
//                registry.addViewController("/admin").setViewName("admin/index");
                registry.addRedirectViewController("/", "/app/");
            }
        };
    }

    @Bean
    public WebMvcConfigurer resources() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                if (!registry.hasMappingForPattern("/app/*.js")) {
                    registry.addResourceHandler("/app/*.js", "/app/*.css", "/app/*.ico").addResourceLocations(APP_CLASSPATH_RESOURCE_LOCATIONS);
                }
                if (!registry.hasMappingForPattern("/admin/*.js")) {
                    registry.addResourceHandler("/admin/*.js", "/admin/*.css", "/admin/*.ico").addResourceLocations(ADMIN_CLASSPATH_RESOURCE_LOCATIONS);
                }
            }
        };
    }

}
