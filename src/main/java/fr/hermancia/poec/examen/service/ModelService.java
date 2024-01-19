package fr.hermancia.poec.examen.service;

import fr.hermancia.poec.examen.DTO.ModelDTO;
import fr.hermancia.poec.examen.entity.Brand;
import fr.hermancia.poec.examen.entity.Model;
import fr.hermancia.poec.examen.exception.NotFoundHermanciaException;
import fr.hermancia.poec.examen.repository.BrandRepository;
import fr.hermancia.poec.examen.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService implements DAOServiceInterface<Model> {

    private ModelRepository modelRepository;
    @Override
    public List<Model> findAll() {
        return modelRepository.findAll() ;
    }

    public Model getObjectById(Long id) {
        Optional<Model> optionalModel = findByField(id.toString());
        if (optionalModel.isEmpty()) {
            throw new NotFoundHermanciaException("Model", "id", id);
        }
        return optionalModel.get();
    }

    public Optional<Model> findByField(String string) {

            try {
                Long id = Long.parseLong(string);
                return modelRepository.findById(id);
            } catch (NumberFormatException e) {
                return modelRepository.findByName(string);
            }
        }
    public Model create(ModelDTO modelDTO, Long id) {
        if (id != null && modelRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaException(
                    "Model", "id", id
            );
        }

        Model model = new Model();
        model.setId(id);
        model.setName(modelDTO.getName());
        return modelRepository.saveAndFlush(model);
    }
}


