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
    private Double hoursPerDay;

    public PointageEmploye(Employe employe, Calendar calendar, Double hoursPerDay) {
        this.employe = employe;
        this.dayWork = new HashMap<>();
        this.calendar = calendar;
        this.hoursPerDay = hoursPerDay;
    }

    public void  addDayWork(LocalDate date,boolean isNigthSwift){
        dayWork.put(date, isNigthSwift);
    }

    public Double calculateHoursPerDay(){
        return dayWork.size() * hoursPerDay;
    }

    public Double hourOfWork(){
         Double heureTotales = 0.0;
         int monthJune = 6;

        for(LocalDate date : dayWork.keySet()){
            if(date.getMonthValue() == monthJune){
                if (dayWork.get(date)){
                    heureTotales += 14.0;
                }
            }else {
                heureTotales += 10.0;
            }
        }

        return heureTotales;
    }
    public Double calculateSalary() {
        double salary = 0.0;

        for (LocalDate date : dayWork.keySet()){
       if(!calendar.getDayOff().contains(date)){
          salary += employe.getMontantDuSalaire().getSalaireBrut();
         }
        }
        return salary;
    }

    public double calculateSalaryWithIncrease(){
        double salary = 0.0;
        double salaryDaily = employe.getMontantDuSalaire().getSalaireBrut() / 7;

        for (LocalDate date : dayWork.keySet()){
            if (!calendar.getDayOff().contains(date)){
                 salary += salaryDaily;
            }else {
                salary += salaryDaily * 1.3;
            }

        }
        return salary;
    }

    public Double calculateSalaryWithOutDayOff (){
        int dayWorks = (int) dayWork.keySet().stream()
                .filter(date -> !calendar.getDayOff().contains(date))
                .count();
        int weekWorks = dayWorks / 7;
        return (double) (weekWorks  * employe.getMontantDuSalaire().getSalaireBrut());
    }

    public double calculateSalaryWithBonus (){

        int dayWorks = (int) dayWork.keySet().stream()
                .filter(date -> !calendar.getDayOff().contains(date))
                .count();

        int weeksWorked = dayWorks / 7;
        double normalSalary = weeksWorked * employe.getMontantDuSalaire().getSalaireBrut();
        double salaryWithBonus = normalSalary * 1.3;
        return salaryWithBonus;
    }

    public void addAllDayOfWork(PointageEmploye pointage, List<LocalDate>dayOff, LocalDate startDate, LocalDate endDate, boolean isNightShift){
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)){
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if(!dayOff.contains(date)){
                pointage.addDayWork(date,isNightShift);
            }
        }
    }
}
