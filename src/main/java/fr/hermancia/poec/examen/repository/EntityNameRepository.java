package fr.hermancia.poec.examen.repository;

import java.util.Optional;

public interface EntityNameRepository <T> {

    Optional<T> findByName(String name);
}
