package com.example.miniproject.services.interfaces;

import com.example.miniproject.dtos.VehiculeDTO;
import com.example.miniproject.entities.VehiculeFlotte;

import java.util.List;

public interface VehiculeFlotteService {


    VehiculeFlotte getVehiculeFlotteById(Long id);

    List<VehiculeFlotte> getAllVehiculesFlotte();

    void deleteVehiculeFlotte(Long id);

    void updateVehiculeFlotte(Long id, VehiculeFlotte updatedVehiculeFlotte);
    public VehiculeFlotte saveVehiculeFlotte(VehiculeDTO vehiculeFlotteDto);
    public List<VehiculeFlotte> saveAllVehiculeFlotte(List<VehiculeDTO> vehiculesFlotte);

}
