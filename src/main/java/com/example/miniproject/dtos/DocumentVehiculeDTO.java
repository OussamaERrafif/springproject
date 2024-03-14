package com.example.miniproject.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DocumentVehiculeDTO {

    private String nomVehicule;
    private String nomConducteur;
    private Date dateVignette;
    private Date dateAssurance;
    private Date dateVisiteTechnique;
    private Date dateCarteGrise;


}
