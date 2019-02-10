import org.json.JSONObject;

public class DetailedInfo {
    static public String getTemperature(JSONObject data){
        return String.valueOf(data.getLong("temp"));
    }
    static public String getMinTemperature(JSONObject data){
        return String.valueOf(data.getLong("temp_min"));
    }
    static public String getHumidity(JSONObject data){
        return String.valueOf(data.getLong("humidity"));
    }
    static public String getPressure(JSONObject data){
        return String.valueOf(data.getLong("pressure"));
    }
    static public String getMaxTemperature(JSONObject data){
        return String.valueOf(data.getLong("temp_max"));
    }

}