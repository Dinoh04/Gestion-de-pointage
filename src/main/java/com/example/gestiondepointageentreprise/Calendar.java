package com.example.gestiondepointageentreprise;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Calendar {
    private int year;
    private Month month;
    private List<LocalDate> dayOff;

    public Calendar(int year, Month month) {
        this.year = year;
        this.month = month;
        this.dayOff = new ArrayList<>();
    }

    public void addDayOf(LocalDate dayOffs){
        dayOff.add(dayOffs);
    }

    public void CrééCalendrier(){
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            boolean isDayOff = dayOff.contains(date);


            String guardianStatus;

            if (isDayOff) {
                guardianStatus = "dayOff";
            } else if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                guardianStatus = "Rest";
            } else {
                guardianStatus = "Work";
            }
            date = date.plusDays(1);
        }
    }

    }

