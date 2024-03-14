package com.example.miniproject.utils;

import com.example.miniproject.dtos.VoyagePlanifieDTO;
import com.example.miniproject.entities.VoyagePlanifie;

public class VoyagePlanifieMapper {

    public static VoyagePlanifieDTO entityToDto(VoyagePlanifie voyagePlanifie) {
        VoyagePlanifieDTO dto = new VoyagePlanifieDTO();
        dto.setDateDepart(voyagePlanifie.getDateDepart());
        dto.setHeureDepart(voyagePlanifie.getHeureDepart());
        dto.setDateArriveePrevue(voyagePlanifie.getDateArriveePrevue());
        dto.setHeureArriveePrevue(voyagePlanifie.getHeureArriveePrevue());
        dto.setDepart(voyagePlanifie.getDepart());
        dto.setDestination(voyagePlanifie.getDestination());
        dto.setTypeVehicule(voyagePlanifie.getTypeVehicule());
        dto.setNombrePassagers(voyagePlanifie.getNombrePassagers());
        dto.setAutresDetails(voyagePlanifie.getAutresDetails());
        return dto;
    }

    public static VoyagePlanifie dtoToEntity(VoyagePlanifieDTO dto) {
        VoyagePlanifie entity = new VoyagePlanifie();
        entity.setDateDepart(dto.getDateDepart());
        entity.setHeureDepart(dto.getHeureDepart());
        entity.setDateArriveePrevue(dto.getDateArriveePrevue());
        entity.setHeureArriveePrevue(dto.getHeureArriveePrevue());
        entity.setDepart(dto.getDepart());
        entity.setDestination(dto.getDestination());
        entity.setTypeVehicule(dto.getTypeVehicule());
        entity.setNombrePassagers(dto.getNombrePassagers());
        entity.setAutresDetails(dto.getAutresDetails());
        return entity;
    }
}
