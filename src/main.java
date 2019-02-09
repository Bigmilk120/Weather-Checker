
import org.json.JSONArray;
import org.json.JSONObject;

public class main {

    final static String DEGREE  = "\u00b0";

    public static void main(String[] args) {

            JSONObject json = WeatherConnection.weatherGetter();
            JSONObject data = json.getJSONObject("main");

            System.out.println("Temperature at this moment: "+data.getLong("temp")+DEGREE+"C");


            JSONArray weather = json.getJSONArray("weather");
            JSONObject description = weather.getJSONObject(0);


            System.out.println("Weather today :"+description.getString("description"));


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



    }
}
