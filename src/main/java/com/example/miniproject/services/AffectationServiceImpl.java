package com.example.miniproject.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import com.example.miniproject.services.interfaces.AffectationService;
import com.example.miniproject.services.interfaces.Conducteurservice;
import com.example.miniproject.services.interfaces.VoyagePlanifieService;
import com.example.miniproject.utils.VoyagePlanifieMapper;

import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImpl implements AffectationService {

    @Autowired
    Conducteurservice conducteurservice;

    @Autowired
    ConducteurserviceImpl conducteurService;

    @Autowired
    VehiculeFlotteServiceImpl vehiculeFlotteService;

    @Autowired
    ConducteurRepository conducteurRepository;

    @Autowired
    VoyagePlanifieRepository voyagePlanifieRepository;

    
    //assign a driver to a planned trip
    @Override
    public Void affecterConducteur(VoyagePlanifie voyage) {
        String heureDepart = voyage.getHeureDepart();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();
        String typeVehiculeRequis = voyage.getVehicule().getTypeVehicule();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();

        List<Conducteur> conducteursDisponibles = conducteurService.getConducteursDisponibles(heureDepart, dateDepart,
                dateArriveePrevue, typeVehiculeRequis, heureArriveePrevue);
        for (Conducteur conducteur : conducteursDisponibles) {
            if (conducteur.getTypePermis().equalsIgnoreCase(voyage.getVehicule().getTypePermisRequis())) {
                List<VoyagePlanifie> existingVoyages = conducteur.getVoyagePlanifie();
                for (VoyagePlanifie existingVoyage : existingVoyages) {
                    if (existingVoyage.getDateDepart().equals(voyage.getDateDepart())
                            && existingVoyage.getDateArriveePrevue().equals(voyage.getDateArriveePrevue())) {
                        return null;
                    }
                }
                conducteur.addVoyagePlanifie(voyage);
            }

        }
        return null;
    }

    //assign a vehicle to a planned trip
    @Override
    public int affecterVehicule(VoyagePlanifie voyage) {
        String heureDepart = voyage.getHeureDepart();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();
        String typeVehiculeRequis = voyage.getTypeVehicule();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();

        List<VehiculeFlotte> vehiculesDisponibles = vehiculeFlotteService.getVehiculesDisponibles(heureDepart, dateDepart,
                dateArriveePrevue, heureArriveePrevue,typeVehiculeRequis );
        if (vehiculesDisponibles.size() > 0) {
            VehiculeFlotte vehicule = vehiculesDisponibles.get(0);
            voyage.setVehicule(vehicule);
            voyagePlanifieRepository.save(voyage);
            System.out.println("Vehicule affected successfully!");
            return 1;
        }
        System.out.println("Failed to affect vehicule.");
        return 0;
    }

    

}
