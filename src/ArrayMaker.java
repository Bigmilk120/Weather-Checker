import org.json.JSONObject;

public class ArrayMaker {
    static public void setInfo(String[] info, JSONObject data){
        info[0]=String.valueOf(data.getLong("temp"));
        info[1]=String.valueOf(data.getLong("temp_min"));
        info[2]=String.valueOf(data.getLong("humidity"));
        info[3]=String.valueOf(data.getLong("pressure"));
        info[4]=String.valueOf(data.getLong("temp_max"));
    }
}