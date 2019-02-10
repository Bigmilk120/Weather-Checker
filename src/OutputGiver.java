import org.json.JSONArray;
import org.json.JSONObject;

class OutputGiver {
    private final static String DEGREE  = "\u00b0";
    static String giveTemperature(JSONObject data){
        return "Temperature at this moment: "+data.getLong("temp")+DEGREE+"C";
    }
    static String giveWeather(JSONObject description){
        return "Weather today: "+description.getString("description");
    }
    static JSONObject getData(String city){
        JSONObject json = WeatherConnection.weatherGetter(city);
        return json.getJSONObject("main");
    }
    static JSONObject getDescription(String city){
        JSONObject json = WeatherConnection.weatherGetter(city);
        JSONArray weather = json.getJSONArray("weather");
        return weather.getJSONObject(0);
    }
}