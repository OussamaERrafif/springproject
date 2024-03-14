package com.example.miniproject.utils;

import com.example.miniproject.dtos.BonConsommationDTO;
import com.example.miniproject.entities.BonConsommation;

public class BonConsommationMapper {

    public static BonConsommationDTO entityToDto(BonConsommation bonConsommation) {
        BonConsommationDTO dto = new BonConsommationDTO();
        dto.setDateVoyage(bonConsommation.getDateVoyage());
        dto.setKilometresParcourus((int) bonConsommation.getKilometresParcourus());
        dto.setTypeCarburant(bonConsommation.getTypeCarburant());
        dto.setQuantiteCarburant(bonConsommation.getQuantiteCarburant());
        dto.setCoutCarburant(bonConsommation.getCoutCarburant());
        dto.setLieuRavitaillement(bonConsommation.getLieuRavitaillement());
        return dto;
    }

    public static BonConsommation dtoToEntity(BonConsommationDTO dto) {
        BonConsommation entity = new BonConsommation();
        // Assuming setters are available for all fields in entity class
        entity.setDateVoyage(dto.getDateVoyage());
        entity.setKilometresParcourus(dto.getKilometresParcourus());
        entity.setTypeCarburant(dto.getTypeCarburant());
        entity.setQuantiteCarburant(dto.getQuantiteCarburant());
        entity.setCoutCarburant(dto.getCoutCarburant());
        entity.setLieuRavitaillement(dto.getLieuRavitaillement());
        return entity;
    }
}
