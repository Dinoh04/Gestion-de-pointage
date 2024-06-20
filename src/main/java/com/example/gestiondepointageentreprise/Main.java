package com.example.gestiondepointageentreprise;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

     List<LocalDate> allDayOff = new ArrayList<>();
        Salaire salaire = new Salaire(110000.0);
       Categories categories = new Categories("Guardian",56,200.0,0.0);
        Employe ben = new Employe("Endrick","Evan",78952, LocalDate.of(2000, Month.JANUARY, 8),LocalDate.now(),LocalDate.of(2026, Month.JANUARY,8),salaire,categories);

        Calendar calendrierjuin = new Calendar(2024, Month.JUNE);


        calendrierjuin.addDayOf(LocalDate.of(2024, 6, 17));
        calendrierjuin.addDayOf(LocalDate.of(2024, 6, 25));
        calendrierjuin.addDayOf(LocalDate.of(2024, 6, 26));

        PointageEmploye pointage = new PointageEmploye(ben, calendrierjuin);

        pointage.addDayWork(LocalDate.of(2024, 6, 3));
        pointage.addDayWork(LocalDate.of(2024,6,4));
        pointage.addDayWork(LocalDate.of(2024, 6, 5));
        pointage.addDayWork(LocalDate.of(2024, 6, 6));
        pointage.addDayWork(LocalDate.of(2024,6,10));
        pointage.addDayWork(LocalDate.of(2024,6,15));
        pointage.addDayWork(LocalDate.of(2024,6,29));
        pointage.addDayWork(LocalDate.of(2024,6,27));
        pointage.addDayWork(LocalDate.of(2024,6,28));
        pointage.addDayWork(LocalDate.of(2024,6,29));
        pointage.addDayWork(LocalDate.of(2024,6,30));


        Double hourJuin = pointage.hourOfWork();

        Double salaryJune = pointage.calculateSalary();

        System.out.println("Heures travaillées en juin : " + hourJuin);
        System.out.println("Salaire à payer pour Rakoto en juin : " + salaryJune);
    }
}
