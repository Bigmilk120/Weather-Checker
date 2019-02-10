import org.json.JSONObject;

public class DetailedInfo {
    static public String getTemperature(String[] info, JSONObject data){
        return String.valueOf(data.getLong("temp"));
    }
    static public String getMinTemperature(String[] info, JSONObject data){
        return String.valueOf(data.getLong("temp_min"));
    }
    static public String getHumidity(String[] info, JSONObject data){
        return String.valueOf(data.getLong("humidity"));
    }
    static public String getPressure(String[] info, JSONObject data){
        return String.valueOf(data.getLong("pressure"));
    }
    static public String getMaxTemperature(String[] info, JSONObject data){
        return String.valueOf(data.getLong("temp_max"));
    }

}