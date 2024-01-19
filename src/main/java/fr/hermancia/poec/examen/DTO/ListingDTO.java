package fr.hermancia.poec.examen.DTO;

import fr.hermancia.poec.examen.validator.group.ValidationGroup;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class ListingDTO {

    @NotBlank(
            message = "Veuillez renseigner un titre ",
            groups = ValidationGroup.OnPutItem.class
    )
    private String title;

    @NotBlank(
            message = "Veuillez renseigner une description ",
            groups = ValidationGroup.OnPutItem.class
    )
    private String description;

    @NotBlank(
            message = "Veuillez renseigner une année de production ",
            groups = ValidationGroup.OnPutItem.class
    )
    private int producedYear;

    @NotBlank(
            message = "Veuillez renseigner un kilométrage ",
            groups = ValidationGroup.OnPutItem.class
    )
    private Long mileage;
    @NotBlank(
            message = "Veuillez renseigner un prix ",
            groups = ValidationGroup.OnPutItem.class
    )
    private double price;
    @NotBlank(
            message = "Veuillez renseigner une date de création ",
            groups = ValidationGroup.OnPutItem.class
    )
    private Date createdAt;
    @NotBlank(
            message = "Veuillez renseigner un modèle ",
            groups = ValidationGroup.OnPutItem.class
    )
    private Long model_id;
}
