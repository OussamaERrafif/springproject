package com.example.miniproject.repositories;

import com.example.miniproject.entities.DocumentVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentVehiculeRepository extends JpaRepository<DocumentVehicule, Long> {
}
