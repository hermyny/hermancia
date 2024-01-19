package fr.hermancia.poec.examen.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.examen.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.examen.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Model implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ModelView.class)
    private Long id;


    @JsonView(JsonViews.ModelView.class)
    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JsonView(JsonViews.ModelView.class)
    private Brand brand;

    private String slug;

    @Override
    public String getField() {
        return name;
    }
}
