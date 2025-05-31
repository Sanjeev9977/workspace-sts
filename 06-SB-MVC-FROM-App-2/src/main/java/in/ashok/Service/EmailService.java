package in.ashok.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    
    public void sendForgetPasswordEmail(String to, String subject, String body) throws MessagingException {
    	   // Create a MIME message
        MimeMessage mimeMessage = mailSender.createMimeMessage();
    	
        // Use MimeMessageHelper to assist in adding content
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        // Set email details
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true); // 'true' indicates the body is HTML content
        
        // Send the email
        mailSender.send(mimeMessage);
    }
    
}

