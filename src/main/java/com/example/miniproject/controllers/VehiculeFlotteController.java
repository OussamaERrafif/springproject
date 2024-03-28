package com.example.miniproject.controllers;

import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.services.interfaces.VehiculeFlotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeFlotteController {

    @Autowired
    private VehiculeFlotteService vehiculeFlotteService;

    @PostMapping
    public ResponseEntity<VehiculeFlotte> saveVehiculeFlotte(@RequestBody VehiculeFlotte vehiculeFlotte) {
        VehiculeFlotte savedVehiculeFlotte = vehiculeFlotteService.saveVehiculeFlotte(vehiculeFlotte);
        return new ResponseEntity<>(savedVehiculeFlotte, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeFlotte> getVehiculeFlotteById(@PathVariable Long id) {
        VehiculeFlotte vehiculeFlotte = vehiculeFlotteService.getVehiculeFlotteById(id);
        if (vehiculeFlotte != null) {
            return new ResponseEntity<>(vehiculeFlotte, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<VehiculeFlotte>> getAllVehiculesFlotte() {
        List<VehiculeFlotte> vehiculesFlotte = vehiculeFlotteService.getAllVehiculesFlotte();
        return new ResponseEntity<>(vehiculesFlotte, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehiculeFlotte(@PathVariable Long id, @RequestBody VehiculeFlotte updatedVehiculeFlotte) {
        vehiculeFlotteService.updateVehiculeFlotte(id, updatedVehiculeFlotte);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculeFlotte(@PathVariable Long id) {
        vehiculeFlotteService.deleteVehiculeFlotte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
