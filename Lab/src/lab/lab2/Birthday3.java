package lab.lab2;

import java.time.LocalDate;
import java.util.Scanner;

public class Birthday3 {

    public static void main (String[] args){
        int month, day, year;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birth mounth [1...12]: ");
        month = scanner.nextInt();

        System.out.println("Enter your birth day of month: ");
        day = scanner.nextInt();

        System.out.println("Enter your birth year[4-digit year]: ");
        year = scanner.nextInt();

        int nowMonth = LocalDate.now().getMonthValue();
        int nowDay = LocalDate.now().getDayOfMonth();
        if(month < nowMonth){
            System.out.println("Your birthday has already happened this year");
        }
        else if(month > nowMonth){
            System.out.println("Your birthday has not yet happened this year");
        }
        else{
            if(day < nowDay){
                System.out.println("Your birthday has already happened this year");
            }
            else if(day > nowDay){
                System.out.println("Your birthday has not yet happened this year");
            }
            else{
                System.out.println("Happy Birthday!");
            }
        }
    }

}
