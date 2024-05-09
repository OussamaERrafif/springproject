package com.example.miniproject.services.interfaces;

import com.example.miniproject.entities.VoyagePlanifie;

public interface AffectationService {

    public int affecterConducteur(VoyagePlanifie voyage);
    public int affecterVehicule(VoyagePlanifie voyage);
    public int affecterConducteurEtVehicule(Long idcon ,Long idveh ,VoyagePlanifie voyage);
    

}
