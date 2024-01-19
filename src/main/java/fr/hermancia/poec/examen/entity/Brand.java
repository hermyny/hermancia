package fr.hermancia.poec.examen.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.examen.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.examen.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Brand implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.BrandView.class)
    private Long id;

    @JsonView(JsonViews.BrandView.class)
    @Column(nullable = false)
    private String name;

    private String slug;

    @Override
    public String getField() {
        return name;
    }
}
