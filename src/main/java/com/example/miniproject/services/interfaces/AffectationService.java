package com.example.miniproject.services.interfaces;

import java.util.Date;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.VoyagePlanifie;

public interface AffectationService {

    public Void affecterConducteur(VoyagePlanifie voyage);
    public int affecterVehicule(VoyagePlanifie voyage);
    

}
