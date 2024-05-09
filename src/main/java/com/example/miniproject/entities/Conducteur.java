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

    @OneToMany(mappedBy = "Conducteur" , cascade = CascadeType.ALL)
    private List<VoyagePlanifie> VoyagePlanifie;
    @OneToMany(mappedBy = "Conducteur", cascade = CascadeType.ALL)
    private List<BonConsommation> bonConsommations;

    private String prenom;
    private String nom;
    private String matriculeEmploye;
    private Date dateNaissance;
    private String numeroCIN;
    private String numeroPermis;
    private Date dateDelivrancePermis;
    private String typePermis;

    public void addVoyagePlanifie(VoyagePlanifie voyage) {
        this.VoyagePlanifie.add(voyage);
    }

}
