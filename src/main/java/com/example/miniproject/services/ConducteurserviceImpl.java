package com.example.miniproject.services;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import com.example.miniproject.services.interfaces.Conducteurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConducteurserviceImpl implements Conducteurservice {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VoyagePlanifieRepository VoyagePlanifieRepository;

    public Optional<Conducteur> getConducteurById(Long id) {
        return conducteurRepository.findById(id);
    }

    public void addConducteur(ConducteurDTO conducteurDTO) {
        Conducteur conducteur = new Conducteur();
        conducteur.setPrenom(conducteurDTO.getPrenom());
        conducteur.setNom(conducteurDTO.getNom());
        conducteur.setMatriculeEmploye(conducteurDTO.getMatriculeEmploye());
        conducteur.setDateNaissance(conducteurDTO.getDateNaissance());
        conducteur.setNumeroCIN(conducteurDTO.getNumeroCIN());
        conducteur.setNumeroPermis(conducteurDTO.getNumeroPermis());
        conducteur.setDateDelivrancePermis(conducteurDTO.getDateDelivrancePermis());
        conducteur.setTypePermis(conducteurDTO.getTypePermis());
        conducteurRepository.save(conducteur);
    }

    public void addConducteur(List<ConducteurDTO> conducteurDTO) {
        for (ConducteurDTO conducteur : conducteurDTO) {
            addConducteur(conducteur);
        }
    }

    public void deleteConducteur(Long id) {
        conducteurRepository.deleteById(id);
    }

    public void updateConducteur(Long id, ConducteurDTO conducteurDTO) {
        Conducteur conducteur = conducteurRepository.findById(id).orElseThrow();
        conducteur.setPrenom(conducteurDTO.getPrenom());
        conducteur.setNom(conducteurDTO.getNom());
        conducteur.setMatriculeEmploye(conducteurDTO.getMatriculeEmploye());
        conducteur.setDateNaissance(conducteurDTO.getDateNaissance());
        conducteur.setNumeroCIN(conducteurDTO.getNumeroCIN());
        conducteur.setNumeroPermis(conducteurDTO.getNumeroPermis());
        conducteur.setDateDelivrancePermis(conducteurDTO.getDateDelivrancePermis());
        conducteur.setTypePermis(conducteurDTO.getTypePermis());

    }

    public List<Conducteur> getAllConducteurs() {
        return conducteurRepository.findAll();
    }

    public List<VoyagePlanifie> getVoyagesConducteurs(Long idConducteur) {

        return VoyagePlanifieRepository.findVoyagesByConducteurId(idConducteur);

    }
    public List<Conducteur> getConducteursDisponibles(String heureDepart, Date dateDepart, Date dateArriveePrevue,
                                                      String heureArriveePrevue, String typeVehicule) {

        List<Conducteur> allConducteurs = conducteurRepository.findAll();
        List<Conducteur> conducteursDisponibles = new ArrayList<>();

        for (Conducteur conducteur : allConducteurs) {
            boolean isAvailable = true;

            // Check if the conducteur's permit type matches the required vehicle type
            if (!conducteur.getTypePermis().equalsIgnoreCase(typeVehicule)) {
                continue;
            }

            List<VoyagePlanifie> voyagesConducteur = VoyagePlanifieRepository.findVoyagesByConducteurId(conducteur.getIdconducteur());

            for (VoyagePlanifie voyage : voyagesConducteur) {
                // Check for overlapping voyages
                boolean startsDuringTrip = dateDepart.after(voyage.getDateDepart()) && dateDepart.before(voyage.getDateArriveePrevue());
                boolean endsDuringTrip = dateArriveePrevue.after(voyage.getDateDepart()) && dateArriveePrevue.before(voyage.getDateArriveePrevue());
                boolean spansTrip = dateDepart.before(voyage.getDateDepart()) && dateArriveePrevue.after(voyage.getDateArriveePrevue());

                if (startsDuringTrip || endsDuringTrip || spansTrip) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                conducteursDisponibles.add(conducteur);
            }
        }

        return conducteursDisponibles;
    }


}
