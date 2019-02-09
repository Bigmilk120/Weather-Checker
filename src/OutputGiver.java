import org.json.JSONArray;
import org.json.JSONObject;

public class OutputGiver {
    final static String DEGREE  = "\u00b0";
    public static void getOutput(JSONObject data, JSONObject description){
        System.out.println("Temperature at this moment: "+data.getLong("temp")+DEGREE+"C");
        System.out.println("Weather today: "+description.getString("description"));
    }
}
