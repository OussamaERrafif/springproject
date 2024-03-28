package com.example.miniproject.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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

    Conducteurservice conducteurservice;

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
            String heureArriveePrevue) {

        List<Conducteur> allConducteurs = conducteurservice.getAllConducteurs();
        List<Conducteur> conducteursDisponibles = new ArrayList<Conducteur>();

        for (Conducteur conducteur : allConducteurs) {

            List<VoyagePlanifie> voyagesconducteur = conducteurservice
                    .getVoyagesConducteurs(conducteur.getIdconducteur());

            for (VoyagePlanifie voyage : voyagesconducteur) {

                boolean startsDuringTrip = dateDepart.after(voyage.getDateDepart())
                        && dateDepart.before(voyage.getDateArriveePrevue());
                boolean endsDuringTrip = dateArriveePrevue.after(voyage.getDateDepart())
                        && dateArriveePrevue.before(voyage.getDateArriveePrevue());
                boolean spansTrip = dateDepart.before(voyage.getDateDepart())
                        && dateArriveePrevue.after(voyage.getDateArriveePrevue());

                if (startsDuringTrip || endsDuringTrip || spansTrip
                        || conducteur.getTypePermis() != voyage.getTypeVehicule()) {
                    continue;

                } else {
                    conducteursDisponibles.add(conducteur);
                }

            }

        }

        // TODO Auto-generated method stub
        return conducteursDisponibles;
    }

}
