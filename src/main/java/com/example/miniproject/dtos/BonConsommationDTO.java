package com.example.miniproject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BonConsommationDTO {

    private Long id;
    private String nomVehicule;
    private String nomConducteur;
    private Date dateVoyage;
    private int kilometresParcourus;
    private String typeCarburant;
    private double quantiteCarburant;
    private double coutCarburant;
    private String lieuRavitaillement;

    // Getters and setters

}