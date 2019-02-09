
import org.json.JSONArray;
import org.json.JSONObject;

public class main {
    public static void main(String[] args) {

        JSONObject json = WeatherConnection.weatherGetter();
        JSONObject data = json.getJSONObject("main");
        JSONArray weather = json.getJSONArray("weather");
        JSONObject description = weather.getJSONObject(0);


        String[] info = new String[5];
        ArrayMaker.setInfo(info,data);
        System.out.println(info[2]);

        OutputGiver.getOutput(data, description);
    }
}
