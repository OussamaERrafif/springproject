package com.example.miniproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BonConsommation {

    @Id
    @GeneratedValue
    private Long idBonConsommation;

    @ManyToOne
    @JoinColumn(name = "id")
    private VehiculeFlotte vehicule;

    @ManyToOne
    @JoinColumn(name = "id")
    private Conducteur conducteur;


    private Date dateVoyage;
    private double kilometresParcourus;
    private String typeCarburant;
    private double quantiteCarburant;
    private double coutCarburant;
    private String lieuRavitaillement;
}
