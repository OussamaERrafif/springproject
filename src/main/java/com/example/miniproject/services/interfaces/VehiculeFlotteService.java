package com.example.miniproject.services.interfaces;

import com.example.miniproject.entities.VehiculeFlotte;

import java.util.List;

public interface VehiculeFlotteService {

    VehiculeFlotte saveVehiculeFlotte(VehiculeFlotte vehiculeFlotte);

    VehiculeFlotte getVehiculeFlotteById(Long id);

    List<VehiculeFlotte> getAllVehiculesFlotte();

    void deleteVehiculeFlotte(Long id);

    void updateVehiculeFlotte(Long id, VehiculeFlotte updatedVehiculeFlotte);

}
