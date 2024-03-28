package com.example.miniproject.services;

import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.repositories.VehiculeFlotteRepository;
import com.example.miniproject.services.interfaces.VehiculeFlotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeFlotteServiceImpl implements VehiculeFlotteService {

    @Autowired
    private VehiculeFlotteRepository vehiculeFlotteRepository;

    @Override
    @Transactional
    public VehiculeFlotte saveVehiculeFlotte(VehiculeFlotte vehiculeFlotte) {
        return vehiculeFlotteRepository.save(vehiculeFlotte);
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
}
