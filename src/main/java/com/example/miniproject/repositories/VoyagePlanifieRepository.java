package com.example.miniproject.repositories;

import com.example.miniproject.entities.Conducteur;
import com.example.miniproject.entities.VehiculeFlotte;
import com.example.miniproject.entities.VoyagePlanifie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyagePlanifieRepository extends JpaRepository<VoyagePlanifie, Long> {
    List<VoyagePlanifie> findByDestination(String destination);

    @Query("SELECT v FROM VoyagePlanifie v WHERE v.Conducteur.idconducteur = :conducteurId")
    List<VoyagePlanifie> findVoyagesByConducteurId(@Param("conducteurId") Long conducteurId);

}
