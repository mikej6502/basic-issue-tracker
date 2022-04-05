package uk.practicalcoding.issuetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BasicIssueTrackerApplication
{
    public static void main( final String[] args )
    {
        SpringApplication.run( BasicIssueTrackerApplication.class, args );
    }

    @Autowired
    private Environment env;

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings( CorsRegistry registry )
            {
                System.out.println( "DBNAME: " + env.getProperty( "spring.data.mongodb.database" ) );

                registry.addMapping( "/**" ).
                        allowedMethods( "GET", "PUT", "POST" ).
                        allowedOrigins( "https://bassic-issue-tracker-ui-staging.azurewebsites.net" );
            }
        };
    }
}
