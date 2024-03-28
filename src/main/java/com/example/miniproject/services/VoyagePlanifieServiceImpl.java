package com.example.miniproject.services;

import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.ConducteurRepository;
import com.example.miniproject.repositories.VehiculeFlotteRepository;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import com.example.miniproject.services.interfaces.VoyagePlanifieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoyagePlanifieServiceImpl implements VoyagePlanifieService {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private VehiculeFlotteRepository vehiculeFlotteRepository;

    @Autowired
    private VoyagePlanifieRepository voyagePlanifieRepository;


    public Optional<VoyagePlanifie> getVoyageById(long id){
            return voyagePlanifieRepository.findById(id);
    }


    @Override
    public VoyagePlanifie add(VoyagePlanifie voyagePlanifie) {

        return voyagePlanifieRepository.save(voyagePlanifie);
    }

    @Override
    public void deleteById(long id) {
        voyagePlanifieRepository.deleteById(id);
    }

    @Override
    public Optional<VoyagePlanifie> getbyid(long id) {return voyagePlanifieRepository.findById(id);}

    @Override
    public VoyagePlanifie getbyDate() {
        return null;
    }

    @Override
    public <list>VoyagePlanifie getbydest(String dest) {return (VoyagePlanifie) voyagePlanifieRepository.findByDestination(dest);}


    @Override
    public List<VoyagePlanifie> getAllVoyages() {
        return voyagePlanifieRepository.findAll();
    }

}