import org.json.JSONArray;
import org.json.JSONObject;

public class OutputGiver {
    final static String DEGREE  = "\u00b0";
    public static String giveTemperature(JSONObject data, JSONObject description){
        return "Temperature at this moment: "+data.getLong("temp")+DEGREE+"C";
    }
    public static String giveWeather(JSONObject data, JSONObject description){
        return "Weather today: "+description.getString("description");
    }
    public static JSONObject getData(){
        JSONObject json = WeatherConnection.weatherGetter();
        JSONObject data = json.getJSONObject("main");
        return data;
    }
    public static JSONObject getDescription(){
        JSONObject json = WeatherConnection.weatherGetter();
        JSONArray weather = json.getJSONArray("weather");
        JSONObject description = weather.getJSONObject(0);
        return description;
    }
}
