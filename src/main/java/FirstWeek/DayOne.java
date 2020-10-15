package FirstWeek;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class DayOne {
    private static final String
            BASE_URI = "http://worldtimeapi.org/api/timezone/Europe/Moscow";


    public static void dayOneTaskOneGreetings() {

        String userName = getStringFromUser();
        int hour = getCurrentTimeInHour();
        checkCondionsForTime(hour,userName);
    }

    public static  void dayOneTaskTwoGreetings() throws IOException, ParseException {
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

    public static int parseJsonToTakeHour(String json) throws ParseException {
       String currTimeTotal = JsonPath.parse(json).read("$.datetime"); //честно украдено. очень не хотелось мучаться с POJO
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
       Date currTime = dateFormat.parse(currTimeTotal);
       SimpleDateFormat format = new SimpleDateFormat("HH");
       int hour = Integer.parseInt(format.format(currTime));
       return hour;

    }

    public static String getRequest(String url_path) throws IOException
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url_path);
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        StringBuffer result = new StringBuffer();
        int statuscode = httpresponse.getStatusLine().getStatusCode();
        if (statuscode == 200) {

            while (sc.hasNext()) {
                result.append(sc.nextLine());
            }
        }
        else
            {
                System.out.println("Server died :-)");
            }
        return String.valueOf(result);
    }

}
