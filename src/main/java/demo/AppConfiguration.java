package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:/app.properties")
public class AppConfiguration {
	private @Value("${embeddedDatabase}") String embeddedDatabase;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	  return new PropertySourcesPlaceholderConfigurer();
	}

	public String getEmbeddedDatabase() {
		return embeddedDatabase;
	}

	public void setEmbeddedDatabase(String embeddedDatabase) {
		this.embeddedDatabase = embeddedDatabase;
	}

}
