package com.example.miniproject.repositories;

import com.example.miniproject.entities.VehiculeFlotte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeFlotteRepository extends JpaRepository<VehiculeFlotte, Long> {

    @Query(value = "SELECT v.type_permis_requis FROM vehicule_flotte v WHERE v.type_vehicule = :typecar LIMIT 1", nativeQuery = true)
    String findTypePermisRequisByTypeVehicule(String typecar);

}
