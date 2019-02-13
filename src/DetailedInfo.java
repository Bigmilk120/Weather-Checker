import org.json.JSONObject;

class DetailedInfo {
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