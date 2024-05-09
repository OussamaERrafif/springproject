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
    public int affecterConducteur(VoyagePlanifie voyage) {
        String heureDepart = voyage.getHeureDepart();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();
        String typeVehiculeRequis = voyage.getVehicule().getTypeVehicule();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();

        List<Conducteur> conducteursDisponibles = conducteurService.getConducteursDisponibles(heureDepart, dateDepart,
                dateArriveePrevue, heureArriveePrevue, typeVehiculeRequis);
        if (conducteursDisponibles.size() > 0) {
            Conducteur conducteur = conducteursDisponibles.get(0);
            voyage.setConducteur(conducteur);
            voyagePlanifieRepository.save(voyage);
            System.out.println("Conducteur affected successfully!");
            return 1;
        }
        System.out.println("Failed to affect conducteur.");
        return 0;

    }

    @Override
    public int affecterConducteurEtVehicule(Long idcon ,Long idveh ,VoyagePlanifie voyage) {
        String heureDepart = voyage.getHeureDepart();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();
        String typeVehiculeRequis = voyage.getTypeVehicule();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();
        //get the driver by id
        Conducteur conducteur = conducteurRepository.findById(idcon).orElse(null);
        //get the vehicle by id
        VehiculeFlotte vehicule = vehiculeFlotteService.getVehiculeFlotteById(idveh);
        List<Conducteur> conducteursDisponibles = conducteurService.getConducteursDisponibles(heureDepart, dateDepart,
                dateArriveePrevue, heureArriveePrevue, typeVehiculeRequis);
        List<VehiculeFlotte> vehiculesDisponibles = vehiculeFlotteService.getVehiculesDisponibles(heureDepart, dateDepart,
                dateArriveePrevue, heureArriveePrevue, typeVehiculeRequis);
        if (conducteursDisponibles.size() > 0 && vehiculesDisponibles.size() > 0) {
            if (conducteursDisponibles.contains(conducteur) && vehiculesDisponibles.contains(vehicule)) {
                voyage.setConducteur(conducteur);
                voyage.setVehicule(vehicule);
                voyagePlanifieRepository.save(voyage);
                System.out.println("Conducteur and vehicule affected successfully!");
                return 1;
            }else{
                System.out.println("Failed to affect conducteur and vehicule.");
                return 0;
            }
        }
        return 0;


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
