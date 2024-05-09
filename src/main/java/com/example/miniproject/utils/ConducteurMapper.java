package com.example.miniproject.utils;

import com.example.miniproject.dtos.ConducteurDTO;
import com.example.miniproject.entities.Conducteur;

public class ConducteurMapper {

    public static ConducteurDTO entityToDto(Conducteur conducteur) {
        ConducteurDTO dto = new ConducteurDTO();
        dto.setNom(conducteur.getNom());
        dto.setPrenom(conducteur.getPrenom());
        dto.setMatriculeEmploye(conducteur.getMatriculeEmploye());
        dto.setDateNaissance(conducteur.getDateNaissance());
        dto.setNumeroCIN(conducteur.getNumeroCIN());
        dto.setNumeroPermis(conducteur.getNumeroPermis());
        return dto;
    }

    public static Conducteur dtoToEntity(ConducteurDTO dto) {
        Conducteur entity = new Conducteur();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setMatriculeEmploye(dto.getMatriculeEmploye());
        entity.setDateNaissance(dto.getDateNaissance());
        entity.setNumeroCIN(dto.getNumeroCIN());
        entity.setNumeroPermis(dto.getNumeroPermis());
        return entity;
    }
}
