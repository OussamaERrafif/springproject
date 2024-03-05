package com.example.miniproject.services;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.VoyagePlanifieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoyagePlanifieService {

    @Autowired
    private VoyagePlanifieRepository voyagePlanifieRepository;

    public void createVoyagePlanifie(VoyagePlanifieDTO requestDTO) {
        VoyagePlanifie voyagePlanifie = new VoyagePlanifie();
        voyagePlanifie.setDateDepart(requestDTO.getDateDepart());
        voyagePlanifie.setHeureDepart(String.valueOf(requestDTO.getHeureDepart()));
        voyagePlanifie.setDateArriveePrevue(requestDTO.getDateArriveePrevue());
        voyagePlanifie.setHeureArriveePrevue(String.valueOf(requestDTO.getHeureArriveePrevue()));
        voyagePlanifie.setDepart(requestDTO.getDepart());
        voyagePlanifie.setDestination(requestDTO.getDestination());
        voyagePlanifie.setTypeVehicule(requestDTO.getTypeVehicule());
        voyagePlanifie.setNombrePassagers(requestDTO.getNombrePassagers());
        voyagePlanifie.setAutresDetails(requestDTO.getAutresDetails());

        voyagePlanifieRepository.save(voyagePlanifie);
    }
}
