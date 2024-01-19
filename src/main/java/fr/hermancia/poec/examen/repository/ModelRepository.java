package fr.hermancia.poec.examen.repository;

import fr.hermancia.poec.examen.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository
        extends
        JpaRepository<Model, Long>,
        EntityNameRepository<Model>{
}
