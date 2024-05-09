package com.example.miniproject.services;

import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.repositories.VehiculeFlotteRepository;


import com.example.miniproject.services.interfaces.VehiculeFlotteService;
import com.example.miniproject.utils.VehiculeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniproject.dtos.VehiculeDTO;


import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class VehiculeFlotteServiceImpl implements VehiculeFlotteService {

    @Autowired
    private VehiculeFlotteRepository vehiculeFlotteRepository;


    @Autowired
    private VoyagePlanifieServiceImpl VoyagePlanifieService;

    

    @Override
    public VehiculeFlotte saveVehiculeFlotte(VehiculeDTO vehiculeFlotteDto) {
        VehiculeFlotte VehiculeFlotte = VehiculeMapper.dtoToEntity(vehiculeFlotteDto);
        return vehiculeFlotteRepository.save(VehiculeFlotte);
    }

    @Override
    public List<VehiculeFlotte> saveAllVehiculeFlotte(List<VehiculeDTO> vehiculesFlotte) {
        List<VehiculeFlotte> vehicules = new ArrayList<>();
        for (VehiculeDTO vehiculeFlotte : vehiculesFlotte) {
            vehicules.add(VehiculeMapper.dtoToEntity(vehiculeFlotte));
        }
        return vehiculeFlotteRepository.saveAll(vehicules);
    }


    @Override
    @Transactional(readOnly = true)
    public VehiculeFlotte getVehiculeFlotteById(Long id) {
        Optional<VehiculeFlotte> vehiculeFlotteOptional = vehiculeFlotteRepository.findById(id);
        return vehiculeFlotteOptional.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculeFlotte> getAllVehiculesFlotte() {
        return vehiculeFlotteRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteVehiculeFlotte(Long id) {
        vehiculeFlotteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateVehiculeFlotte(Long id, VehiculeFlotte updatedVehiculeFlotte) {
        Optional<VehiculeFlotte> vehiculeFlotteOptional = vehiculeFlotteRepository.findById(id);
        if (vehiculeFlotteOptional.isPresent()) {
            VehiculeFlotte existingVehiculeFlotte = vehiculeFlotteOptional.get();
            existingVehiculeFlotte.setIdentifiantUnique(updatedVehiculeFlotte.getIdentifiantUnique());
            existingVehiculeFlotte.setMarque(updatedVehiculeFlotte.getMarque());
            existingVehiculeFlotte.setModele(updatedVehiculeFlotte.getModele());
            existingVehiculeFlotte.setTypeVehicule(updatedVehiculeFlotte.getTypeVehicule());
            existingVehiculeFlotte.setKilometrage(updatedVehiculeFlotte.getKilometrage());
            existingVehiculeFlotte.setDisponibilite(updatedVehiculeFlotte.isDisponibilite());
            existingVehiculeFlotte.setTypePermisRequis(updatedVehiculeFlotte.getTypePermisRequis());
            existingVehiculeFlotte.setEquipementsSpeciaux(updatedVehiculeFlotte.getEquipementsSpeciaux());
            vehiculeFlotteRepository.save(existingVehiculeFlotte);
        }
    }
    public List<VehiculeFlotte> getVehiculesDisponibles(String heureDepart, Date dateDepart, Date dateArriveePrevue,
                                                        String heureArriveePrevue, String typeVehiculeRequis) {

        List<VehiculeFlotte> allVehicules = vehiculeFlotteRepository.findAll();
        List<VehiculeFlotte> vehiculesDisponibles = new ArrayList<>();

        for (VehiculeFlotte vehicule : allVehicules) {
            boolean isAvailable = true;

            // Check if the vehicle type matches the required type
            if (!vehicule.getTypePermisRequis().equalsIgnoreCase(typeVehiculeRequis)) {
                continue;
            }

            List<VoyagePlanifie> voyagesVehicule = VoyagePlanifieService.getVoyagesVehicule(vehicule.getIdVehiculeFlotte());

            for (VoyagePlanifie voyage : voyagesVehicule) {
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
                vehiculesDisponibles.add(vehicule);
            }
        }

        return vehiculesDisponibles;
    }
}
