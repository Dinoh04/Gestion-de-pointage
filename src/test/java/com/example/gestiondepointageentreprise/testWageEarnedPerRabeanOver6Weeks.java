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
public class testWageEarnedPerRabeanOver6Weeks {

    private static final Logger log = LoggerFactory.getLogger(testWageEarnedPerRabeanOver6Weeks.class);

    @Test
    public void WageEarnedPerRabeAnOver6Weeks(){
        LocalDate startDate = LocalDate.of(2024, Month.MAY, 26);
        LocalDate endDate = LocalDate.of(2024, Month.JULY, 6);

        List<LocalDate> allDayOff = new ArrayList<>();

        Salaire salaire = new Salaire(100000.0);
        Categories categories = new Categories("Guardian",56,100000.0,0.0);
        Employe Rabe = new Employe("Rabe", "Jean",85474,LocalDate.of(1999,Month.AUGUST,7),LocalDate.now(),LocalDate.of(2026,Month.AUGUST,7),salaire,categories);
        Calendar calendarJune = new Calendar(2024, Month.JUNE);

        PointageEmploye rabePointage = new PointageEmploye(Rabe,calendarJune,14.0);
        rabePointage.addAllDayOfWork(rabePointage,allDayOff, startDate, endDate, true);

        double rabeSalary = rabePointage.calculateSalaryWithBonus();
        double salaryExpected = 780000.0;

        log.info("Rabe's earnings over 6 weeks (night shift) : "+ rabeSalary);

        assertEquals(salaryExpected, rabeSalary, 0.01, "The salary earned by Rabe is incorrect over 6 weeks with a mark-up.");

    }
}
