package fr.hermancia.poec.examen.service;

import fr.hermancia.poec.examen.entity.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    JavaMailSender javaMailSender;
    public void send(Validation validation) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("no-reply@hermyny.sa");
        mailMessage.setTo(validation.getUser().getEmail());
        mailMessage.setSubject("Votre code d'activation");
        String text = String.format("Bonjour %s, <br> Votre code d'activation est le suivant: %s; A très vite!",
                validation.getUser().getName(),
                validation.getCode());
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);



    }
}