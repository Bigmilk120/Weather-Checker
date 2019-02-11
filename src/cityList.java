import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


public class cityList {
    public static ArrayList<String> getList() {
        ArrayList<String> city = new ArrayList<>();
        String filename = "city.txt";
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String cityName = sc.nextLine();
                city.add(cityName);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println(Arrays.toString(city.toArray()));
        city.remove(city.size()-1);
        return city;
    }
}
