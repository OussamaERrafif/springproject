package com.example.miniproject.controllers;

import java.util.Optional;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.services.VoyagePlanifieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.services.interfaces.AffectationService;

@RestController
@RequestMapping("/affectation")
public class AffectationController {

    @Autowired
    AffectationService affectationService;

    @Autowired
    VoyagePlanifieServiceImpl voyagePlanifieService;

    // Affect a conducteur to a voyage
    @PutMapping(path = "/affectercon/{id}", produces = "application/json")
    public ResponseEntity<String> affecterConducteur(@PathVariable Long id) {
        try {
            // Get the voyage by id
            Optional<VoyagePlanifie> voyageOptional = voyagePlanifieService.getVoyageById(id);
            
            if (voyageOptional.isPresent()) {
                VoyagePlanifie voyage = voyageOptional.get();
                
                // Call the service method to affect a conducteur to the voyage
                int result = affectationService.affecterConducteur(voyage);
                
                // Check if the operation was successful
                if (result != 0) {
                    return ResponseEntity.status(HttpStatus.OK).body("Conducteur affected successfully!");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to affect conducteur.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voyage not found.");
            }
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Affect a vehicule to a voyage
    @PutMapping(path = "/affecterveh/{id}", produces = "application/json")
    public ResponseEntity<String> affecterVehicule(@PathVariable Long id) {
        try {
            // Get the voyage by id
            Optional<VoyagePlanifie> voyageOptional = voyagePlanifieService.getVoyageById(id);
            
            if (voyageOptional.isPresent()) {
                VoyagePlanifie voyage = voyageOptional.get();
                
                // Call the service method to affect a vehicule to the voyage
                int result = affectationService.affecterVehicule(voyage);
                
                // Check if the operation was successful
                if (result != 0) {
                    return ResponseEntity.status(HttpStatus.OK).body("Vehicule affected successfully!");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to affect vehicule.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voyage not found.");
            }
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Affect a conducteur and a vehicule to a voyage
    @PutMapping(path = "/affecterconveh/{idcon}/{idveh}/{id}", produces = "application/json")
    public ResponseEntity<String> affecterConducteurEtVehicule(@PathVariable Long idcon, @PathVariable Long idveh, @PathVariable Long id) {
        try {
            // Get the voyage by id
            Optional<VoyagePlanifie> voyageOptional = voyagePlanifieService.getVoyageById(id);
            
            if (voyageOptional.isPresent()) {
                VoyagePlanifie voyage = voyageOptional.get();
                
                // Call the service method to affect a conducteur and a vehicule to the voyage
                int result = affectationService.affecterConducteurEtVehicule(idcon, idveh, voyage);
                
                // Check if the operation was successful
                if (result != 0) {
                    return ResponseEntity.status(HttpStatus.OK).body("Conducteur and vehicule affected successfully!");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to affect conducteur and vehicule.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voyage not found.");
            }
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}
