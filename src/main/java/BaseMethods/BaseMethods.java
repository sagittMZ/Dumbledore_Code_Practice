package BaseMethods;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class BaseMethods {
    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    public static int getIntFromUser() {
        Scanner in = new Scanner(System.in);
        int num0 = 0;
        if (in.hasNextInt()) {
            int num = in.nextInt();
            in.close();
            return num;
        } else {
            System.out.println("Вы ввели не целое число");
            in.close();
            return num0;
        }
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
