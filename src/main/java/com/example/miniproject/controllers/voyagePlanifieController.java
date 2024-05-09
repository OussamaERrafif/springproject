
package com.example.miniproject.controllers;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.services.VoyagePlanifieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voyages")
public class voyagePlanifieController {

    @Autowired
    private VoyagePlanifieServiceImpl voyagePlanifieService;

    @GetMapping(path="/{id}", produces = "application/json")
    public Optional<VoyagePlanifie> getVoyageById(@PathVariable Long id) {
        return voyagePlanifieService.getVoyageById(id);
    }


    @GetMapping(produces = "application/json")
    public List<VoyagePlanifie> getAllVoyages() {
        return voyagePlanifieService.getAllVoyages();
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addVoyage(@RequestBody VoyagePlanifieDTO voyagePlanifie) {
        VoyagePlanifie addedVoyage = voyagePlanifieService.add(voyagePlanifie);
        if (addedVoyage != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Voyage added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add voyage.");
        }
    }

    //post mapping to add more than one voyage
    @PostMapping(path="/addVoyages", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addVoyages(@RequestBody List<VoyagePlanifieDTO> voyagePlanifieList) {
        List<VoyagePlanifie> addedVoyages = voyagePlanifieService.addVoyages(voyagePlanifieList);
        if (addedVoyages != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Voyages added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add voyages.");
        }
    }


    @DeleteMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<String> deleteVoyageById(@PathVariable Long id) {
        Optional<VoyagePlanifie> voyage = voyagePlanifieService.getVoyageById(id);
        if (voyage.isPresent()) {
            voyagePlanifieService.deleteById(id);
            return ResponseEntity.ok("Voyage with ID " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
