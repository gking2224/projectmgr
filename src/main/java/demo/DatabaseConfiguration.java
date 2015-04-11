package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DatabaseConfiguration {
		
	private @Value("${embeddedDatabase}") boolean embeddedDatabase;
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertyConfigurer() {
		PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("app.properties"));
		
		return ppc;
	}
}
