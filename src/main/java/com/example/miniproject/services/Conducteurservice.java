package com.example.miniproject.services;

import java.util.List;
import java.util.Optional;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;

public interface Conducteurservice {
    public Optional<Conducteur> getConducteurById(Long id);

    public void addConducteur(ConducteurDTO conducteurDTO);

    public void deleteConducteur(Long id);

    public void updateConducteur(Long id, ConducteurDTO conducteurDTO);

    public List<Conducteur> getAllConducteurs();

    public void affecterConducteur(long idConducteur, Long idVoyagePlanifie, Long idVehiculeFlotte);

}
