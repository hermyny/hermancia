package fr.hermancia.poec.examen.service;

import fr.hermancia.poec.examen.entity.User;
import fr.hermancia.poec.examen.entity.Validation;
import fr.hermancia.poec.examen.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@AllArgsConstructor
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationService notificationService;

    public void registrate(User user) {

        Validation validation = new Validation();
        validation.setUser(user);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, ChronoUnit.MINUTES);
        validation.setExpire(expiration);

        Random random = new Random();
        int codeInt = random.nextInt(999999);
        String code = String.format("%06d",codeInt);
        validation.setCode(code);
        this.validationRepository.save(validation);
        this.notificationService.send(validation);
    }

    public Validation readByCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(()-> new RuntimeException("Votre code est invalide"));

    }



}
