package com.example.miniproject.services.interfaces;
import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.entities.VoyagePlanifie;

import java.util.List;
import java.util.Optional;

public interface VoyagePlanifieService {

    public VoyagePlanifie add(VoyagePlanifieDTO voyagePlanifiedto);

    public void deleteById(long id);

    public Optional<VoyagePlanifie> getbyid(long id);

    public VoyagePlanifie getbyDate();

    <list>VoyagePlanifie getbydest(String dest);

    List<VoyagePlanifie>  getAllVoyages();
    List<VoyagePlanifie> getVoyagesVehicule(Long vehiculeId);
}
