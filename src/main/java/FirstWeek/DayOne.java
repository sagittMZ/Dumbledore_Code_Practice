package FirstWeek;

import BaseMethods.BaseMethods;
import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


public class DayOne extends BaseMethods {
    private static final String
            BASE_URI = "http://worldtimeapi.org/api/timezone/Europe/Moscow";

    public static void dayOneTaskOneGreetings() {
        System.out.println("Введите ваше имя: ");
        String userName = getStringFromUser();
        int hour = getCurrentTimeInHour();
        checkCondionsForTime(hour,userName);
    }

    public static  void dayOneTaskTwoGreetings() throws IOException, ParseException {
        System.out.println("Введите ваше имя: ");
        String userName = getStringFromUser();
        int hour = parseJsonToTakeHour(getRequest(BASE_URI));
        checkCondionsForTime(hour,userName);
    }

    public static void checkCondionsForTime(int hour, String userName){
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

    public static int getCurrentTimeInHour(){
        int  current_hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return current_hour;
    }

    public static int parseJsonToTakeHour(String json) throws ParseException {
       String currTimeTotal = JsonPath.parse(json).read("$.datetime"); //честно украдено. очень не хотелось мучаться с POJO
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
       Date currTime = dateFormat.parse(currTimeTotal);
       SimpleDateFormat format = new SimpleDateFormat("HH");
       int hour = Integer.parseInt(format.format(currTime));
       return hour;

    }

}
