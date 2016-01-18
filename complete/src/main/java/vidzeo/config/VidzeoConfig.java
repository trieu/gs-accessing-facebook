package vidzeo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:vidzeo.properties")
public class VidzeoConfig {

	@Value("${wordpress.username}")
	String wordpressUsername;
	
	@Value("${wordpress.password}")
	String wordpressPassword;
	
	@Value("${wordpress.xmlrpcUrl}")
	String wordpressXmlrpcUrl;
	
	public VidzeoConfig() {
		System.out.println("init VidzeoConfig...");
	}
	

	public String getWordpressUsername() {
		return wordpressUsername;
	}
	public String getWordpressPassword() {
		return wordpressPassword;
	}
	public String getWordpressXmlrpcUrl() {
		return wordpressXmlrpcUrl;
	}
	
	
}
