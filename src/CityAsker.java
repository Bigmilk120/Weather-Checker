import java.util.Scanner;

public class CityAsker {
    static public String askCity(){
        Scanner r = new Scanner(System.in);
        String city = r.nextLine();
        return city;
    }
}
