package com.example.gestiondepointageentreprise;


import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalendarTest {

    @Test
     public void testCalendar(){
        Calendar calendarJune = new Calendar(2024, Month.JUNE);

        LocalDate dayOffOne = LocalDate.of(2024,6,17);
        LocalDate dayOffTwo = LocalDate.of(2024,6,25);
        LocalDate dayOffThree = LocalDate.of(2024,6,26);

        calendarJune.addDayOf(dayOffOne);
        calendarJune.addDayOf(dayOffTwo);
        calendarJune.addDayOf(dayOffThree);

        List<LocalDate> allDayOff = calendarJune.getDayOff();

        assertEquals(3, allDayOff.size(), "Le nombre de jours fériés doit être de 3");
        assertTrue(allDayOff.contains(dayOffOne),"Le 17 juin 2024 doit être un jour férié");
        assertTrue(allDayOff.contains(dayOffTwo), "Le 25 juin 2024 doit être un jour férié");
        assertTrue(allDayOff.contains(dayOffThree), "Le 26 juin 2024 doit être un jour férié");

    }




}
