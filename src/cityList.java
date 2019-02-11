import java.io.File;
import java.util.*;


public class cityList {
    public static ArrayList<String> getList() {
        ArrayList<String> city = new ArrayList<>();
        String filename = "city.txt";
        File file = new File(filename);
        try {
            Scanner s = new Scanner(file);
            System.out.println(s.nextLine());
            while (s.hasNext()){
                String temp = s.nextLine();
                city.add(temp);
                System.out.println(temp);
            }
            s.close();
        }catch(Exception ex){
            System.out.println(ex);
        }



        city.add("Kraków");
        city.add("Warszawa");
        city.add("Katowice");
        return city;
    }
}
