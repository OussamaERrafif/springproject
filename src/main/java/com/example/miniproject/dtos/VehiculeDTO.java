package com.example.miniproject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiculeDTO {

    private String identifiantUnique;
    private String marque;
    private String modele;
    private String typeVehicule;
    private int kilometrage;
    private boolean disponibilite;
    private String typePermisRequis;
    private List<String> equipementsSpeciaux;

}
