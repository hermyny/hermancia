package fr.hermancia.poec.examen.service;

import fr.hermancia.poec.examen.DTO.BrandDTO;
import fr.hermancia.poec.examen.entity.Brand;
import fr.hermancia.poec.examen.exception.NotFoundHermanciaException;
import fr.hermancia.poec.examen.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService implements DAOServiceInterface<Brand> {
    
    
    private BrandRepository brandRepository;
    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getObjectById(Long id) {
        Optional<Brand> optionalBrand = findByField(id.toString());
        if (optionalBrand.isEmpty()) {
            throw new NotFoundHermanciaException("Brand", "id", id);
        }
        return optionalBrand.get();
    }

    public Optional<Brand> findByField(String string) {
         try {
        Long id = Long.parseLong(string);
        return brandRepository.findById(id);
    } catch (NumberFormatException e) {
        return brandRepository.findByName(string);
    }
}


    public Brand create(BrandDTO brandDTO, Long id) {
        if (id != null && brandRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaException(
                    "Brand", "id", id
            );
        }

        Brand br = new Brand();
        br.setId(id);
        br.setName(brandDTO.getName());

        return brandRepository.saveAndFlush(br);
    }
}


