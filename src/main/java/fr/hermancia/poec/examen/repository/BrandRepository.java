package fr.hermancia.poec.examen.repository;

import fr.hermancia.poec.examen.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository
        extends
        JpaRepository<Brand, Long>,
        EntityNameRepository<Brand>{

    Optional<Brand> findByName(String name);
}
