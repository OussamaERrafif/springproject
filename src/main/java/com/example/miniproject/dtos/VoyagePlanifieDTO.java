package com.example.miniproject.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VoyagePlanifieDTO {

    private Date dateDepart;
    private Date heureDepart;
    private Date dateArriveePrevue;
    private String heureArriveePrevue;
    private String depart;
    private String destination;
    private String typeVehicule;
    private int nombrePassagers;
    private String autresDetails;

}
