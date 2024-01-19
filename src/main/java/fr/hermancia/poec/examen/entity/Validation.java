package fr.hermancia.poec.examen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Validation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant creation;

    private Instant expire;

    private Instant activation;

    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}

