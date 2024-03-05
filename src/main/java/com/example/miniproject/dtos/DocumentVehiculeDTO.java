package com.example.miniproject.dtos;

import lombok.Setter;

import java.util.Date;

@Setter
public class DocumentVehiculeDTO {

    private Long id;
    private String nomVehicule;
    private String nomConducteur;
    private Date dateVignette;
    private Date dateAssurance;
    private Date dateVisiteTechnique;
    private Date dateCarteGrise;


}
