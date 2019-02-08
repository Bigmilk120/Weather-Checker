
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class main {
    public static String Api = "&appid=96f92938c8efe61afd7512b9e21d37ce&units=metric ";
    public static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=Kraków";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();


        try {
            URL url = new URL(BASE_URL + Api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())
            ));

            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONObject json = new JSONObject(sb.toString());
            JSONObject data = json.getJSONObject("main");

            System.out.println(data.getLong("temp"));


            JSONArray weather = json.getJSONArray("weather");


            JSONObject description = weather.getJSONObject(0);
            System.out.println(description.getString("description"));
            System.out.println(data);
            String[] info = new String[5];
            info[0]=String.valueOf(data.getLong("temp"));
            info[1]=String.valueOf(data.getLong("temp_min"));
            info[2]=String.valueOf(data.getLong("humidity"));
            info[3]=String.valueOf(data.getLong("pressure"));
            info[4]=String.valueOf(data.getLong("temp_max"));

            for(int i=0;i<=4;i++){
                System.out.println(info[i]);
            }


        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
