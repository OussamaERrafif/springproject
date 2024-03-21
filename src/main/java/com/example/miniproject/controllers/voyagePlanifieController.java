
package com.example.miniproject.controllers;

import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.services.VoyagePlanifieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voyages")
public class voyagePlanifieController {

    @Autowired
    private VoyagePlanifieService voyagePlanifieService;

    @GetMapping(path="/{id}", produces = "application/json")

    public Optional<VoyagePlanifie> getVoyageById(@PathVariable Long id) {
        return voyagePlanifieService.getVoyageById(id);
    }
    @GetMapping(produces = "application/json")

    public List<VoyagePlanifie> getAllVoyages() {
        return voyagePlanifieService.getAllVoyages();
    }



}
