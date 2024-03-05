package com.example.miniproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "documents_vehicules")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentVehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private VehiculeFlotte vehicule;

    @Column(name = "date_validite")
    private LocalDate dateValidite;


}
