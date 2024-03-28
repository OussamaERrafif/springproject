package com.example.miniproject.controllers;

import java.util.Date;
import java.util.List;

import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.services.VoyagePlanifieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.services.interfaces.AffectationService;

@RestController
@RequestMapping("/affectation")
public class AffectationController {

    @Autowired
    AffectationService affectationService;

    @Autowired
    VoyagePlanifieService voyagePlanifieService;

    @PutMapping(path = "/affecterConducteur/{idConducteur}/{idVoyagePlanifie}/{idVehiculeFlotte}", produces = "application/json")
    public ResponseEntity<String> affecterConducteur(@PathVariable Long idConducteur,
            @PathVariable Long idVoyagePlanifie,
            @PathVariable Long idVehiculeFlotte) {
        affectationService.affecterConducteur(idConducteur, idVoyagePlanifie, idVehiculeFlotte);

        return ResponseEntity.status(HttpStatus.OK).body("Conducteur added successfully!");

    }

    @GetMapping(path = "/Conducteursdisponibles/{voyagePlanifieId}", produces = "application/json")
    public List<Conducteur> getConducteursDisponibles(@PathVariable Long voyagePlanifieId) {

        VoyagePlanifie voyage = voyagePlanifieService.getVoyageById(voyagePlanifieId).orElseThrow();

        String heureDepart = voyage.getHeureDepart();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();
        String typeVehicule = voyage.getTypeVehicule();

        return affectationService.getConducteursDisponibles(heureDepart, dateDepart, dateArriveePrevue,
                heureArriveePrevue, typeVehicule);
    }

}
