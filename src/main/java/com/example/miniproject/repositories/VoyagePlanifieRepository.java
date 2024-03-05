package com.example.miniproject.repositories;

import com.example.miniproject.entities.VoyagePlanifie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoyagePlanifieRepository extends JpaRepository<VoyagePlanifie, Long> {
}
