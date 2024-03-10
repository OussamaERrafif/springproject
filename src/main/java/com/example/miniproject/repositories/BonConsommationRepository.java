package com.example.miniproject.repositories;

import com.example.miniproject.entities.BonConsommation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonConsommationRepository extends JpaRepository<BonConsommation, Long> {

}
