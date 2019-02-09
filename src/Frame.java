import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(JSONObject data, JSONObject description){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocation(50,50);
        Container container = getContentPane();
        setLayout(new FlowLayout());
        JLabel temperature = new JLabel(OutputGiver.giveTemperature(data,description));
        JLabel weather = new JLabel(OutputGiver.giveWeather(data,description));
        temperature.setPreferredSize(new Dimension(500,100));
        weather.setPreferredSize(new Dimension(500,100));

        container.add(temperature);
        container.add(weather);
        //container.add(new JButton("Przycisk"));

        setVisible(true);
    }
}
