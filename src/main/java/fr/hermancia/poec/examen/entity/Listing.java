package fr.hermancia.poec.examen.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.examen.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.examen.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonView(JsonViews.ListingView.class)
    @Column(nullable = false)
    private String title;


    @JsonView(JsonViews.ListingView.class)
    @Column(nullable = false)
    private String description;


    @JsonView(JsonViews.ListingView.class)
    @Column(nullable = false)
    private int producedYear;


    @JsonView(JsonViews.ListingView.class)
    @Column(nullable = false)
    private Long mileage;


    @JsonView(JsonViews.ListingView.class)
    @Column(nullable = false)
    private Long price;

    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;

    @JsonView(JsonViews.ListingView.class)
    private String image;


    @JsonView(JsonViews.ListingView.class)
    @ManyToOne
    private Model model;

    @ManyToOne
    private User user;

    private String slug;

    @Override
    public String getField() {
        return "vente-"+this.getModel().getBrand().getName()+this.getModel().getName();
    }
}
