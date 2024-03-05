package com.example.miniproject.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VoyagePlanifieDTO {

    private Long id;
    private Date dateDepart;
    private Date heureDepart;
    private Date dateArriveePrevue;
    private Date heureArriveePrevue;
    private String depart;
    private String destination;
    private String typeVehicule;
    private int nombrePassagers;
    private String autresDetails;

    // Getters and setters

}
