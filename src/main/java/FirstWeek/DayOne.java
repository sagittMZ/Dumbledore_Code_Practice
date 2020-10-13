package FirstWeek;

import java.util.Calendar;
import java.util.Scanner;


public class DayOne {
    public static void dayOneTaskOneGreetings() {

        String userName = getStringFromUser();
        int hour = getCurrentTimeInHour();

            if ((0 <= hour) && (hour <= 4))
            {
                System.out.println("Good night, "+userName);
            }
            else if ((5 <= hour) && (hour <= 9))
            {
                System.out.println("Good morning, "+userName);
            }
            else if ((10 <= hour) && (hour <= 16))
            {
                System.out.println("Good afternoon, "+userName);
            }
            else if ((17 <= hour) && (hour <= 23))
            {
                System.out.println("Good evening "+userName);
            }
            else {
                    System.out.println("Looks like Ragnarok  is here. Get the hell out of here now");
                }
    }

    public static String getStringFromUser()  {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        in.close();
        return name;
    }

    public static int getCurrentTimeInHour(){
        int  current_hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return current_hour;
    }

}
