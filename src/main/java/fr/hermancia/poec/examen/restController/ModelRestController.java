package fr.hermancia.poec.examen.restController;

import fr.hermancia.poec.examen.DTO.BrandDTO;
import fr.hermancia.poec.examen.DTO.ModelDTO;
import fr.hermancia.poec.examen.entity.Brand;
import fr.hermancia.poec.examen.entity.Model;
import fr.hermancia.poec.examen.service.ModelService;
import fr.hermancia.poec.examen.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Model> showOne(@PathVariable String field) {
        return modelService.findByField(field);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Model create(@Valid @RequestBody ModelDTO modelDTO) {
        return modelService.create(modelDTO, null);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Model  persist(@Valid @RequestBody ModelDTO modelDTO, @PathVariable Long id) {
        return modelService.create(modelDTO, id);
    }
}


