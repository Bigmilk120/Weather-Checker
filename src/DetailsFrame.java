import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class DetailsFrame extends JFrame {
    private final static String DEGREE  = "\u00b0";
    DetailsFrame(JSONObject data){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setLocation(100,100);
        JLabel jlb = new JLabel();
        jlb.setIcon(new ImageIcon(getClass().getResource("rain.jpg")));

        Container container = getContentPane();
        container.setLayout(new FlowLayout());


        JLabel temperature = new JLabel("Today's temperature is: "+DetailedInfo.getTemperature(data)+DEGREE+"C");
        temperature.setPreferredSize(new Dimension(250,25));
        JLabel minTemperature = new JLabel("The lowest temperature in the city: "+DetailedInfo.getMinTemperature(data)+DEGREE+"C");
        minTemperature.setPreferredSize(new Dimension(250,25));
        JLabel maxTemperature = new JLabel("The highest temperature in the city: "+DetailedInfo.getMaxTemperature(data)+DEGREE+"C");
        maxTemperature.setPreferredSize(new Dimension(250,25));
        JLabel humidity = new JLabel("Humidity: "+DetailedInfo.getHumidity(data)+"%");
        humidity.setPreferredSize(new Dimension(250,25));
        JLabel pressure = new JLabel("Pressure: "+DetailedInfo.getPressure(data)+"hPa");
        pressure.setPreferredSize(new Dimension(250,25));

        container.add(temperature);
        container.add(minTemperature);
        container.add(maxTemperature);
        container.add(humidity);
        container.add(pressure);
        container.add(jlb);

        setVisible(true);
    }
}
