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
public class testWageEarnedByRakotoOver6WeeksWithDaysFeries {

    private static final Logger log = LoggerFactory.getLogger(testWageEarnedByRakotoOver6WeeksWithDaysFeries.class);

    @Test
    public void WageEarnedByRakotoOver6WeeksWithDaysFeries(){
        LocalDate startDate = LocalDate.of(2024, Month.MAY, 26);
        LocalDate endDate = LocalDate.of(2024, Month.JULY, 6);


        List<LocalDate> dayOff = new ArrayList<>();
        dayOff.add(LocalDate.of(2024, Month.JUNE, 17));
        dayOff.add(LocalDate.of(2024, Month.JUNE, 25));
        dayOff.add(LocalDate.of(2024, Month.JUNE, 26));

        Calendar calendar = new Calendar(2024, Month.JUNE);
        calendar.setDayOff(dayOff);


        Salaire salaire = new Salaire(100000.0);
        Categories categories = new Categories("Guardian",56,100000.0,0.0);
        Employe Rakoto = new Employe("Rakoto", "Jean",85474,LocalDate.of(1999,Month.AUGUST,7),LocalDate.now(),LocalDate.of(2026,Month.AUGUST,7),salaire,categories);
        Calendar calendarJune = new Calendar(2024, Month.JUNE);

        PointageEmploye rakotoPointage = new PointageEmploye(Rakoto,calendarJune,10.0);
        rakotoPointage.addAllDayOfWork(rakotoPointage,dayOff,startDate,endDate,false);
        double salaryRakoto = rakotoPointage.calculateSalaryWithIncrease();



        double salaryExpected =  612856.959;

        log.info("Salary earned by Rakoto over 6 weeks with public holidays : " + salaryRakoto);
        assertEquals(salaryExpected, salaryRakoto, 0.01, "The salary earned by Rakoto is incorrect over 6 weeks with public holidays.");


    }
}
