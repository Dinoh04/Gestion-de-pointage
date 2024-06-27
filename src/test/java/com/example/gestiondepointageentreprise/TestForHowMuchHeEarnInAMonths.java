package com.example.gestiondepointageentreprise;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestForHowMuchHeEarnInAMonths {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    @Test
    public void testHowMuchHeEarsInAMonth(){
        LocalDate startDate = LocalDate.of(2024, Month.MAY, 26);
        LocalDate endDate = LocalDate.of(2024, Month.JULY, 6);

        List<LocalDate> allDayOff = new ArrayList<>();

        Salaire salaire = new Salaire(100000.0);
        Categories categories = new Categories("Guardian",56,100000.0,0.0);
        Employe Rakoto = new Employe("Rakoto","Ravo",78952, LocalDate.of(2000, Month.JANUARY, 8),LocalDate.now(),LocalDate.of(2026, Month.JANUARY,8),salaire,categories);
        Employe Rabe = new Employe("Rabe", "Jean",85474,LocalDate.of(1999,Month.AUGUST,7),LocalDate.now(),LocalDate.of(2026,Month.AUGUST,7),salaire,categories);


        Calendar calendarJune = new Calendar(2024, Month.JUNE);

        PointageEmploye pointageRakoto = new PointageEmploye(Rakoto, calendarJune,10.0);
        pointageRakoto.addAllDayOfWork(pointageRakoto,allDayOff, startDate, endDate, false);

        Double rakotoSalary = pointageRakoto.calculateSalaryWithOutDayOff();

        double salaryExpected = 600000.0;

        log.info("The salary earn by Rakoto in 6 weeks : {} ", rakotoSalary);

        assertEquals(salaryExpected, rakotoSalary, 0.01, "The salary earn by Rakoto in 6 weeks is incorrect");


    }
}
