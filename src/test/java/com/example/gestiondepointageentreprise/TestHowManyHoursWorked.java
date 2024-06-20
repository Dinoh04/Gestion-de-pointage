package com.example.gestiondepointageentreprise;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestHowManyHoursWorked {

    @Test
    public void testHoursWorkedByRakoto(){
        List<LocalDate> allDayOff = new ArrayList<>();
        allDayOff.add(LocalDate.of(2024, 6, 17));
        allDayOff.add(LocalDate.of(2024, 6, 25));
        allDayOff.add(LocalDate.of(2024, 6, 26));

        Salaire salaire = new Salaire(110000.0);
        Categories categories = new Categories("Guardian",56,200.0,0.0);
        Employe Rakoto = new Employe("Rakoto","Ravo",78952, LocalDate.of(2000, Month.JANUARY, 8),LocalDate.now(),LocalDate.of(2026, Month.JANUARY,8),salaire,categories);
        Calendar calendarJune = new Calendar(2024, Month.JUNE);
        calendarJune.setDayOff(allDayOff);

        PointageEmploye pointage = new PointageEmploye(Rakoto, calendarJune);
        pointage.addAllDayOfWork(pointage,allDayOff, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 30));

        Double hourJune = pointage.hourOfWork();

        assertEquals(216.0, hourJune, "The number of hours worked in June is incorrect.");



    }
}
