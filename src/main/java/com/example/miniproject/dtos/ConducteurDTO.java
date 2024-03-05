package com.example.miniproject.dtos;

import com.example.miniproject.entities.Conducteur;

import java.util.Date;
import lombok.*;

@Getter
@Setter
public class ConducteurDTO {

    private Long idconducteur;
    private String nom;
    private String prenom;
    private String matriculeEmploye;
    private Date dateNaissance;
    private String cin;
    private String numeroPermis;
}
