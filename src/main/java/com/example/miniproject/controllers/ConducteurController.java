package com.example.miniproject.controllers;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.services.Conducteurservice;
import com.example.miniproject.services.VoyagePlanifieService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conducteurs")
public class ConducteurController {

    @Autowired
    VoyagePlanifieService voyagePlanifieService;

    @Autowired
    Conducteurservice conducteurservice;

    @GetMapping(produces = "application/json")
    public List<Conducteur> getAllConducteurs() {
        return conducteurservice.getAllConducteurs();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Optional<Conducteur> getConducteurById(@PathVariable Long id) {
        return conducteurservice.getConducteurById(id);
    }

    @PutMapping(path = "/add", produces = "application/json")
    public ResponseEntity<String> addConducteur(@RequestBody ConducteurDTO conducteurDTO) {
        conducteurservice.addConducteur(conducteurDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Conducteur added successfully!");

    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<String> deleteConducteur(@PathVariable Long id) {
        conducteurservice.deleteConducteur(id);
        return ResponseEntity.status(HttpStatus.OK).body("Conducteur deleted successfully!");

    }

    @PostMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity<String> updateConducteur(@PathVariable Long id, @RequestBody ConducteurDTO conducteurDTO) {
        conducteurservice.updateConducteur(id, conducteurDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Conducteur updated successfully!");

    }

    @PostMapping(value = "/affecter", produces = "application/json")
    public ResponseEntity<String> affecterConducteur(@PathVariable Long idVoyagePlanifie,
            @PathVariable Long idConducteur,
            @PathVariable Long idVehiculeFlotte) {
        conducteurservice.affecterConducteur(idConducteur, idVoyagePlanifie, idVehiculeFlotte);
        return ResponseEntity.status(HttpStatus.OK).body("Conducteur affected successfully!");

    }

}
