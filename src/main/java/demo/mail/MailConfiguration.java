package demo.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {

    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage templateMessage;
    
    public MailConfiguration() {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setUsername("gking2224@gmail.com");
        mailSender.setPassword("g0t0b3d9)");
        mailSender.setPort(465);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        mailSender.setJavaMailProperties(props);
        
        templateMessage = new SimpleMailMessage();
        templateMessage.setFrom("gking2224+SpringBootDemo@gmail.com");

    }

    @Bean
    public MailSender getMailSender() {
        return mailSender;
    }

    @Bean
    public SimpleMailMessage getTemplateMessage() {
        return templateMessage;
    }
    
}
