package com.example.miniproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconducteur;

    @OneToMany
    private List<VoyagePlanifie> VoyagePlanifie;

    private String prenom;
    private String nom;
    private String matriculeEmploye;
    private Date dateNaissance;
    private String numeroCIN;
    private String numeroPermis;
    private Date dateDelivrancePermis;
    private String typePermis;

}
