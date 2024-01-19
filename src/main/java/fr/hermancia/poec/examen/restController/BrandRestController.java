package fr.hermancia.poec.examen.restController;

import fr.hermancia.poec.examen.DTO.BrandDTO;
import fr.hermancia.poec.examen.entity.Brand;
import fr.hermancia.poec.examen.service.BrandService;
import fr.hermancia.poec.examen.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandRestController {

    private BrandService brandService;

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<Brand> showOne(@PathVariable String field) {
        return brandService.findByField(field);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Brand create(@Valid @RequestBody BrandDTO brandDTO) {
        return brandService.create(brandDTO, null);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Brand  persist(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        return brandService.create(brandDTO, id);
    }
}
