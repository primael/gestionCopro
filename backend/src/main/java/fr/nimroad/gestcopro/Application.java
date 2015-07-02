package fr.nimroad.gestcopro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.nimroad.gestcopro.config.WebContext;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import({WebContext.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
