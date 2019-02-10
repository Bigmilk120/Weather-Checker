import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame {
    Frame(){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocation(50,50);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        setLayout(new FlowLayout());


        JTextField city = new JTextField();
        city.setPreferredSize(new Dimension(500,25));

        JButton confirm_city = new JButton("Confirm");
        confirm_city.setPreferredSize(new Dimension(100,25));

        container.add(city);
        container.add(confirm_city);
        confirm_city.addActionListener(e -> {
            JSONObject data = OutputGiver.getData(city.getText());
            JSONObject description = OutputGiver.getDescription(city.getText());

            JLabel temperature = new JLabel(OutputGiver.giveTemperature(data));
            JLabel weather = new JLabel(OutputGiver.giveWeather(description));
            temperature.setPreferredSize(new Dimension(500,50));
            weather.setPreferredSize(new Dimension(500,50));

            city.setVisible(false);
            confirm_city.setVisible(false);
            container.add(temperature);
            container.add(weather);
        });

        setVisible(true);
    }
}