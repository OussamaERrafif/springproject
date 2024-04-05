package com.example.miniproject.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.miniproject.entities.VehiculeFlotte;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import com.example.miniproject.services.interfaces.AffectationService;
import com.example.miniproject.services.interfaces.Conducteurservice;
import org.springframework.stereotype.Service;

@Service
public class AffectationServiceImpl implements AffectationService {

    @Autowired
    Conducteurservice conducteurservice;

    @Autowired
    private VehiculeFlotteServiceImpl vehiculeFlotteService;

    @Autowired
    private VoyagePlanifieServiceImpl voyagePlanifieService;



    @Autowired
    ConducteurRepository conducteurRepository;

    @Autowired
    VoyagePlanifieRepository voyagePlanifieRepository;

    @SuppressWarnings({ "unchecked", "null" })
    public void affecterConducteur(long idConducteur, Long idVoyagePlanifie, Long idVehiculeFlotte) {
        Conducteur conducteur = conducteurRepository.findById(idConducteur).orElseThrow();
        VoyagePlanifie voyagePlanifie = null;

        voyagePlanifie = voyagePlanifieRepository.findById(idVoyagePlanifie).orElseThrow();

        List<VoyagePlanifie> existingVoyages = conducteur.getVoyagePlanifie();
        existingVoyages.addAll((List<VoyagePlanifie>) voyagePlanifie);

        conducteur.setVoyagePlanifie(existingVoyages);
    }

    public List<Conducteur> getConducteursDisponibles(String heureDepart, Date dateDepart, Date dateArriveePrevue,
            String heureArriveePrevue , String typeVehicule) {

        List<Conducteur> allConducteurs = conducteurservice.getAllConducteurs();
        List<Conducteur> conducteursDisponibles = new ArrayList<Conducteur>();

        for (Conducteur conducteur : allConducteurs) {

            List<VoyagePlanifie> voyagesconducteur = conducteurservice
                    .getVoyagesConducteurs(conducteur.getIdconducteur());

            if (voyagesconducteur.isEmpty()) {
                if(conducteur.getTypePermis().equalsIgnoreCase(typeVehicule)) conducteursDisponibles.add(conducteur);
            } else {
                for (VoyagePlanifie voyage : voyagesconducteur) {

                    boolean startsDuringTrip = dateDepart.after(voyage.getDateDepart())
                            && dateDepart.before(voyage.getDateArriveePrevue());
                    boolean endsDuringTrip = dateArriveePrevue.after(voyage.getDateDepart())
                            && dateArriveePrevue.before(voyage.getDateArriveePrevue());
                    boolean spansTrip = dateDepart.before(voyage.getDateDepart())
                            && dateArriveePrevue.after(voyage.getDateArriveePrevue());
                    boolean typepermismismtch =conducteur.getTypePermis().equalsIgnoreCase(voyage.getTypeVehicule());

                    if (startsDuringTrip || endsDuringTrip || spansTrip
                            || typepermismismtch) {
                        continue;

                    } else {
                        conducteursDisponibles.add(conducteur);
                    }

                }
            }

        }

        // TODO Auto-generated method stub
        return conducteursDisponibles;
    }

    public List<VehiculeFlotte> getVehiculesDisponibles(String heureDepart, Date dateDepart, Date dateArriveePrevue,
                                                        String heureArriveePrevue, String typeVehiculeRequis) {

        List<VehiculeFlotte> allVehicules = vehiculeFlotteService.getAllVehiculesFlotte();
        List<VehiculeFlotte> vehiculesDisponibles = new ArrayList<>();

        for (VehiculeFlotte vehicule : allVehicules) {

            List<VoyagePlanifie> voyagesVehicule = voyagePlanifieService.getVoyagesVehicule(vehicule.getIdVehiculeFlotte());

            if (voyagesVehicule.isEmpty()) {
                if (vehicule.getTypePermisRequis().equalsIgnoreCase(typeVehiculeRequis)) {
                    vehiculesDisponibles.add(vehicule);
                }
                continue;
            } else {
                for (VoyagePlanifie voyage : voyagesVehicule) {

                    boolean startsDuringTrip = dateDepart.after(voyage.getDateDepart())
                            && dateDepart.before(voyage.getDateArriveePrevue());
                    boolean endsDuringTrip = dateArriveePrevue.after(voyage.getDateDepart())
                            && dateArriveePrevue.before(voyage.getDateArriveePrevue());
                    boolean spansTrip = dateDepart.before(voyage.getDateDepart())
                            && dateArriveePrevue.after(voyage.getDateArriveePrevue());
                    boolean typePermisMatch = vehicule.getTypePermisRequis().equalsIgnoreCase(voyage.getTypeVehicule());

                    if (startsDuringTrip || endsDuringTrip || spansTrip || typePermisMatch) {
                        continue;
                    } else {
                        vehiculesDisponibles.add(vehicule);
                    }
                }
            }
        }

        return vehiculesDisponibles;
    }

}
