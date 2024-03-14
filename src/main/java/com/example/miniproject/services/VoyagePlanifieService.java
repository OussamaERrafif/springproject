package com.example.miniproject.services;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VehiculeRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyagePlanifieService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeRepository vehiculeFlotteRepository;

    @Autowired
    private VoyagePlanifieRepository voyagePlanifieRepository;

    public void affecter(Long idVoyagePlanifie, Long idConducteur, Long idVehiculeFlotte) {
        VoyagePlanifie voyage = voyagePlanifieRepository.findById(idVoyagePlanifie).orElseThrow();
        Conducteur conducteur = conducteurRepository.findById(idConducteur).orElseThrow();
        VehiculeFlotte vehicule = vehiculeFlotteRepository.findById(idVehiculeFlotte).orElseThrow();

        voyage.setConducteur(conducteur);
        voyage.setVehicule(vehicule);

        voyagePlanifieRepository.save(voyage);
    }



    public List<VoyagePlanifie> getAllVoyages() {
        return voyagePlanifieRepository.findAll();
    }

    public Optional<VoyagePlanifie> getVoyageById(long id){
            return voyagePlanifieRepository.findById(id);
    }


}