import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherConnection {
    public static String Api = "&appid=96f92938c8efe61afd7512b9e21d37ce&units=metric ";
    public static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    static public JSONObject weatherGetter(String city){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(BASE_URL + city + Api);
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

            return json;
        }catch(Exception ex) {
            System.out.println(ex);
            JSONObject json = new JSONObject();
            return json;
        }
    }
}
