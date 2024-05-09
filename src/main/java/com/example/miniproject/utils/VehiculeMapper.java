package com.example.miniproject.utils;

import com.example.miniproject.dtos.VehiculeDTO;
import com.example.miniproject.entities.VehiculeFlotte;

import java.util.List;

public class VehiculeMapper {

    public static VehiculeDTO entityToDto(VehiculeFlotte vehiculeFlotte) {
        VehiculeDTO dto = new VehiculeDTO();
        dto.setMarque(vehiculeFlotte.getMarque());
        dto.setModele(vehiculeFlotte.getModele());
        dto.setTypeVehicule(vehiculeFlotte.getTypeVehicule());
        dto.setKilometrage((int) vehiculeFlotte.getKilometrage());
        dto.setDisponibilite(vehiculeFlotte.isDisponibilite());
        dto.setTypePermisRequis(vehiculeFlotte.getTypePermisRequis());
        dto.setEquipementsSpeciaux(vehiculeFlotte.getEquipementsSpeciaux() != null ?
                List.of(vehiculeFlotte.getEquipementsSpeciaux().split(",")) :
                List.of());
        return dto;
    }

    public static VehiculeFlotte dtoToEntity(VehiculeDTO dto) {
        VehiculeFlotte entity = new VehiculeFlotte();
        entity.setModele(dto.getModele());
        entity.setMarque(dto.getMarque());
        entity.setTypeVehicule(dto.getTypeVehicule());
        entity.setKilometrage(dto.getKilometrage());
        entity.setDisponibilite(dto.isDisponibilite());
        entity.setTypePermisRequis(dto.getTypePermisRequis());
        if (dto.getEquipementsSpeciaux() != null && !dto.getEquipementsSpeciaux().isEmpty()) {
            entity.setEquipementsSpeciaux(String.join(",", dto.getEquipementsSpeciaux()));
        }
        return entity;
    }
}
