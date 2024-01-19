package fr.hermancia.poec.examen.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationUserDTO {

    @Email(message = "Veuillez renseigner votre email.")
    @NotBlank(message = "L'email doit être renseigné.")// On peut réécrire les valeurs des champs de l'annotation
    private String email;

    @NotBlank(message = "Veuillez renseigner votre nom.")
    private String name;


    @NotBlank(message = "Veuillez renseigner votre mot de passe")
    @Size(message = "Le mot de passe doit contenir au moins neuf caractères.", min = 9)
    private String password;



}
