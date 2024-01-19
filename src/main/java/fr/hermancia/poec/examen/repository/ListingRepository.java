package fr.hermancia.poec.examen.repository;

import fr.hermancia.poec.examen.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository
        extends
        JpaRepository<Listing, Long>
        {
}
