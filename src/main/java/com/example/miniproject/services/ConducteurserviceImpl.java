package com.example.miniproject.services;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import com.example.miniproject.services.interfaces.Conducteurservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<VoyagePlanifie> getVoyagesConducteurs(Long idConducteur) {

        Conducteur conducteur = conducteurRepository.findById(idConducteur).orElseThrow();

        return voyagePlanifieRepository.findVoyagesByConducteurId(idConducteur);

    }

}
