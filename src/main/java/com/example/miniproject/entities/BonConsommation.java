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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBonConsommation;

    @ManyToOne
    @JoinColumn
    private VehiculeFlotte vehicule;

    @ManyToOne
    @JoinColumn
    private Conducteur conducteur;


    private Date dateVoyage;
    private double kilometresParcourus;
    private String typeCarburant;
    private double quantiteCarburant;
    private double coutCarburant;
    private String lieuRavitaillement;
}
