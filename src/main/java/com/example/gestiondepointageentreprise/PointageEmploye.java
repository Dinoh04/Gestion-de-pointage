package com.example.gestiondepointageentreprise;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointageEmploye {

    private Employe employe;
    private Map<LocalDate, Boolean> dayWork;
    private Calendar calendar;

    public PointageEmploye(Employe employe, Calendar calendar) {
        this.employe = employe;
        this.dayWork = new HashMap<>();
        this.calendar = calendar;
    }

    public void  addDayWork(LocalDate date){
        dayWork.put(date, true);
    }

    public Double hourOfWork(){
         Double heureTotales = 0.0;
         int monthJune = 6;

        for(LocalDate date : dayWork.keySet()){
            if(date.getMonthValue() == monthJune){
                heureTotales += 8.0;
            }
        }

        return heureTotales;
    }
    public Double calculateSalary(){
        Double normalHours = 0.0;
        Double bonusHours = 0.0;
        Double overtime = 0.0;
        Double totalSalary = 0.0;

     for (LocalDate date : dayWork.keySet()){
         if (dayWork.get(date)){
           Double hourOfWork = 8.0;

           if (hourOfWork <= 8.0){
               normalHours += hourOfWork;
           }else{
               normalHours += 8.0;
               overtime += hourOfWork - 8.0;
           }
           if (isBonusHours(date)){
              bonusHours += hourOfWork;
           }
         }

     }

     Double  normalHourlyRate = employe.getMontantDuSalaire().getSalaireNet() / 160.0;
     Double overtimeRate = normalHourlyRate * 1.3;
     Double bonusHoursRate = normalHourlyRate * 1.5;
      totalSalary = (normalHours * normalHourlyRate) + (overtime * overtimeRate) + (bonusHours * bonusHoursRate);

      return totalSalary ;
    }

    public Boolean isBonusHours(LocalDate date){
        if (calendar.getDayOff().contains(date)){
            return true;
        }

        if (date.getDayOfWeek() == DayOfWeek.SUNDAY){
            return true;
        }

      return false;
    }

    public void addAllDayOfWork(PointageEmploye pointage, List<LocalDate>dayOff, LocalDate startDate, LocalDate endDate){
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)){
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if(!dayOff.contains(date)){
                pointage.addDayWork(date);
            }
        }
    }
}
