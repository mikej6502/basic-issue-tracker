package uk.practicalcoding.issuetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BasicIssueTrackerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( BasicIssueTrackerApplication.class, args );
    }

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings( CorsRegistry registry )
            {
                registry.addMapping( "/**" ).allowedOrigins( "https://bassic-issue-tracker-ui-staging.azurewebsites.net" );
            }
        };
    }
}
