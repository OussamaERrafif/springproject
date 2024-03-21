package com.example.miniproject.dtos;

import com.example.miniproject.entities.Conducteur;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public class ConducteurDTO {

    private String prenom;
    private String nom;
    private String matriculeEmploye;
    private Date dateNaissance;
    private String numeroCIN;
    private String numeroPermis;
    private Date dateDelivrancePermis;
    private String typePermis;
}
