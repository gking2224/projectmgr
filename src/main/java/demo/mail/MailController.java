package demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

    @Autowired
    private MailSender mailSender;
    
    @Autowired
    private SimpleMailMessage templateMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage template) {
        this.templateMessage = template;
    }

    @RequestMapping("/mail")
    @ResponseBody
    String sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo("gking2224@gmail.com");
        msg.setText("Dear Graham, hurrah!");
        try {
            this.mailSender.send(msg);
            return "mail sent";
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
            return ex.getMessage();
        }
    }
}
