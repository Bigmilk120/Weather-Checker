
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
    public static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=Warsaw";

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


            JSONArray temp = json.getJSONArray("weather");
            JSONObject x = temp.getJSONObject(0);
            System.out.println(x.getString("description"));



        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
