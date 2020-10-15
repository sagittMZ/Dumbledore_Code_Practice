import java.io.IOException;
import java.text.ParseException;

import static FirstWeek.DayOne.dayOneTaskOneGreetings;
import static FirstWeek.DayOne.dayOneTaskTwoGreetings;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите ваше имя: ");
        //dayOneTaskOneGreetings();
        try {
            try {
                dayOneTaskTwoGreetings();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}