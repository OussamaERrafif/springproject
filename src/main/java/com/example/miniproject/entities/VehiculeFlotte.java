package com.example.miniproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VehiculeFlotte {

    @Id
    @GeneratedValue
    private Long idVehiculeFlotte;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<DocumentVehicule> documents;

    private String identifiantUnique;
    private String marqueModele;
    private String typeVehicule;
    private double kilometrage;
    private boolean disponibilite;
    private String typePermisRequis;
    private String equipementsSpeciaux;


}
