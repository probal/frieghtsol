package com.freightsol.freightsol.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.text.MessageFormat;

/**
 * Created by probal on 10/18/17.
 */
@Service
public class MailSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderService.class);

    private JavaMailSender javaMailSender;

    static final String LOGIN_ALERT_SUBJECT = "Freightsol login alert";
    static final String LOGIN_ALERT_BODY = "Hei {0}!<br/><br/> You just logged in to freightsol. Is that you?";


    @Autowired
    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendLoginAlert(String emailTo, String userName) {
        String mailBody = MessageFormat.format(LOGIN_ALERT_BODY, userName);
        try {
            sendMail(emailTo, LOGIN_ALERT_SUBJECT, mailBody);
            LOGGER.info("Login alert mail sent to {}.", emailTo);
        } catch (Exception ex) {
            LOGGER.error("Failed to send Login alert mail to {}", emailTo);
        }

    }


    public void sendMail(String toEmail, String subject, String message) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
