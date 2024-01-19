package fr.hermancia.poec.examen.DTO;

import fr.hermancia.poec.examen.validator.group.ValidationGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandDTO {

    private Long id;

    @NotBlank(
            message = "Veuillez renseigner un nom de marque de voiture ",
            groups = ValidationGroup.OnPutItem.class
    )
    private String name;

}
