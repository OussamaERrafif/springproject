package com.example.miniproject.repositories;

import com.example.miniproject.entities.VehiculeFlotte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<VehiculeFlotte, Long> {
}
