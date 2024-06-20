package com.example.gestiondepointageentreprise;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Employe {
    private String nom;
    private String prenom;
    private int numeroMatricule;
    private LocalDate dateDeNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateDeFinDeContrat;
    private Salaire montantDuSalaire;
    private Categories categorie;
}
