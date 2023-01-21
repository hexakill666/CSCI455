package lab.lab2;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Date {

    public static void main (String[] args){
        LocalDate myDate = LocalDate.of(1995, Month.JANUARY, 20);
        int year = myDate.getYear();
        int month = myDate.getMonthValue();
        int day = myDate.getDayOfMonth();

        LocalDate later = myDate.plusDays(20);
        int yearLater = later.getYear();
        int monthLater = later.getMonthValue();
        int dayLater = later.getDayOfMonth();

        System.out.println(month + "/" + day + "/" + year);
        System.out.println(monthLater + "/" + dayLater + "/" + yearLater);

        myDate = later;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/YYYY");
        System.out.println(formatter.format(myDate));
    }

}
