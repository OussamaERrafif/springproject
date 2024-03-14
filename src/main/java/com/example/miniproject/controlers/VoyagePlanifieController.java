package com.example.miniproject.controlers;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.services.VoyagePlanifieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voyages")
public class VoyagePlanifieController {

    @Autowired
    private VoyagePlanifieService voyagePlanifieService;

    @PostMapping
    public ResponseEntity<VoyagePlanifieDTO> createVoyage(@RequestBody VoyagePlanifieDTO voyagePlanifieDTO) {
        VoyagePlanifieDTO createdVoyage = voyagePlanifieService.createVoyage(voyagePlanifieDTO);
        return new ResponseEntity<>(createdVoyage, HttpStatus.CREATED);
    }
}