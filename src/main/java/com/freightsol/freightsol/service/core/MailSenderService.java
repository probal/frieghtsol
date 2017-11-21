package com.freightsol.freightsol.service.core;

import com.freightsol.freightsol.model.core.Mail;
import com.freightsol.freightsol.model.auth.UserAccount;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by probal on 10/18/17.
 */
@Service
public class MailSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration freemarkerConfig;



    @Autowired
    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendMail(String toEmail, String subject, String message) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendRegistrationMail(UserAccount userAccount) {
        try {
            Map model = new HashMap<>();
            model.put("fullName", userAccount.getFullName());
            model.put("location", "Dhaka");
            model.put("signature", "http://cefalo.com");
            Template template = freemarkerConfig.getTemplate("signup.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            Mail mail = new Mail(userAccount.getEmail(), "Welcome to freightsol", html);
            sendMimeMail(mail);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while sending signup mail to: " + userAccount.getEmail());
        }
    }

    public void sendLoginMail(UserAccount userAccount) {
        try {
            Map model = new HashMap<>();
            model.put("fullName", userAccount.getFullName());
            model.put("location", "Dhaka");
            model.put("signature", "http://cefalo.com");
            Template template = freemarkerConfig.getTemplate("login.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            Mail mail = new Mail(userAccount.getEmail(), "Login Alert!!", html);
            sendMimeMail(mail);
        } catch (Exception ex) {
            LOGGER.error("Error occurred while sending login mail to: " + userAccount.getEmail());
        }
    }

    private void sendMimeMail(Mail mail) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

        helper.setTo(mail.getMailTo());
        helper.setText(mail.getMailContent(), true);
        helper.setSubject(mail.getMailSubject());

        javaMailSender.send(message);
    }
}
