package com.example.gestiondepointageentreprise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
 private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

     List<LocalDate> allDayOff = new ArrayList<>();
     allDayOff.add(LocalDate.of(2024, 6, 17));
     allDayOff.add(LocalDate.of(2024, 6, 25));
     allDayOff.add(LocalDate.of(2024, 6, 26));

        Salaire salaire = new Salaire(110000.0);
       Categories categories = new Categories("Guardian",56,200.0,0.0);
        Employe Rakoto = new Employe("Rakoto","Ravo",78952, LocalDate.of(2000, Month.JANUARY, 8),LocalDate.now(),LocalDate.of(2026, Month.JANUARY,8),salaire,categories);

        Calendar calendrierjuin = new Calendar(2024, Month.JUNE);
          calendrierjuin.setDayOff(allDayOff);



        PointageEmploye pointage = new PointageEmploye(Rakoto, calendrierjuin,10.0);

        pointage.addAllDayOfWork(pointage,allDayOff, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 30),false);


        Double hourJune = pointage.hourOfWork();

        Double salaryJune = pointage.calculateSalary();

     log.info("Salaire à payer pour Rakoto en juin : {}", salaryJune);
     log.info("Total des heures complétés en un mois : {}", hourJune);
    }
}
