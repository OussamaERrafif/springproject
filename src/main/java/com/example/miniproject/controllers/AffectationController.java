package com.example.miniproject.controllers;

import java.util.Date;
import java.util.List;

import com.example.miniproject.entities.VoyagePlanifie;
import com.example.miniproject.services.interfaces.VoyagePlanifieService;
import com.example.miniproject.services.VoyagePlanifieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.services.interfaces.AffectationService;

@RestController
@RequestMapping("/affectation")
public class AffectationController {

    AffectationService affectationService;

    @Autowired
    VoyagePlanifieService voyagePlanifieService;
    VoyagePlanifieServiceImpl VoyagePlanifieServiceimpl;

    @GetMapping(path = "/Conducteursdisponibles/{voyagePlanifieId}", produces = "application/json")
    public List<Conducteur> getConducteursDisponibles(@PathVariable Long voyagePlanifieId) {

        VoyagePlanifie voyage = VoyagePlanifieServiceimpl.getVoyageById(voyagePlanifieId).orElseThrow();

        String heureDepart = voyage.getHeureDepart();
        String heureArriveePrevue = voyage.getHeureArriveePrevue();
        Date dateDepart = voyage.getDateDepart();
        Date dateArriveePrevue = voyage.getDateArriveePrevue();

        return affectationService.getConducteursDisponibles(heureDepart, dateDepart, dateArriveePrevue,
                heureArriveePrevue);
    }

}
