package com.example.miniproject.services.interfaces;

import com.example.miniproject.entities.Conducteur;

import java.util.Date;
import java.util.List;

public interface AffectationService {

    public void affecterConducteur(long idConducteur, Long idVoyagePlanifie, Long idVehiculeFlotte);

    public List<Conducteur> getConducteursDisponibles(String heureDepart, Date dateDepart, Date dateArriveePrevue,
            String heureArriveePrevue , String typeVehicule);
}
