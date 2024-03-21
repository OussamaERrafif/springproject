package com.example.miniproject.services;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ConducteurserviceImpl implements Conducteurservice {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VoyagePlanifieRepository voyagePlanifieRepository;

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

    public void affecterConducteur(long idConducteur, Long idVoyagePlanifie, Long idVehiculeFlotte) {
        Conducteur conducteur = conducteurRepository.findById(idConducteur).orElseThrow();
        VoyagePlanifie voyagePlanifie = voyagePlanifieRepository.findById(idVoyagePlanifie).orElseThrow();
        conducteur.setVoyagePlanifie((List<VoyagePlanifie>) voyagePlanifie);
    }
}
