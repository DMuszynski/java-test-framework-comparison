package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.service.MessageService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service(value = "mailService")
public class MessageServiceImpl implements MessageService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MessageServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMessage(String to, String subject, String content, boolean isHtmlContent) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, isHtmlContent);
            this.javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
