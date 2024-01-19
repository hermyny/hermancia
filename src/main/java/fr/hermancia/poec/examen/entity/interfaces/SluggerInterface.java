package fr.hermancia.poec.examen.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SluggerInterface {

    void setSlug (String slug);

    @JsonIgnore
    String getField();
}
