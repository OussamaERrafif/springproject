package com.example.miniproject.repositories;

import com.example.miniproject.entities.VehiculeFlotte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehiculeFlotteRepository extends JpaRepository<VehiculeFlotte, Long> {

    //@Query("SELECT v.vehicule FROM VoyagePlanifie v WHERE v.dateDepart = :startDate AND v.dateArriveePrevue = :endDate")
    //List<VehiculeFlotte> findVehiculesByDepartAndEndDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
