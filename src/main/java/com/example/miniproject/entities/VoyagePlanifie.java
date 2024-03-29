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
public class VoyagePlanifie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoyagePlanifie;

    @ManyToOne
    private VehiculeFlotte vehicule;

    @ManyToOne
    private Conducteur Conducteur;

    private Date dateDepart;
    private String heureDepart;
    private Date dateArriveePrevue;
    private String heureArriveePrevue;
    private String depart;
    private String destination;
    private String typeVehicule;
    private int nombrePassagers;
    private String autresDetails;
}
