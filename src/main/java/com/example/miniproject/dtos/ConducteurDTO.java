package com.example.miniproject.dtos;

import com.example.miniproject.entities.Conducteur;

import java.util.Date;
import lombok.*;

@Setter

public class ConducteurDTO {

    private Long idconducteur;
    private String nom;
    private String prenom;
    private String matriculeEmploye;
    private Date dateNaissance;
    private String cin;
    private String numeroPermis;

    public static ConducteurDTO fromEntity(Conducteur conducteur) {
        ConducteurDTO conducteurDTO = new ConducteurDTO();
        conducteurDTO.setIdconducteur(conducteur.getIdconducteur());
        conducteurDTO.setNom(conducteur.getNom());
        conducteurDTO.setPrenom(conducteur.getPrenom());
        conducteurDTO.setMatriculeEmploye(conducteur.getMatriculeEmploye());
        conducteurDTO.setDateNaissance(conducteur.getDateNaissance());
        conducteurDTO.setCin(conducteur.getNumeroCIN());
        conducteurDTO.setNumeroPermis(conducteur.getNumeroPermis());
        return conducteurDTO;
    }

}
