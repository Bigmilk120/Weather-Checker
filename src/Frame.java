import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame(){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocation(50,50);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        setLayout(new FlowLayout());


        JTextField city = new JTextField();
        city.setPreferredSize(new Dimension(500,50));

        JButton confirm_city = new JButton("Confirm");
        confirm_city.setPreferredSize(new Dimension(100,50));

        container.add(city);
        container.add(confirm_city);
        confirm_city.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONObject data = OutputGiver.getData(city.getText());
                JSONObject description = OutputGiver.getDescription(city.getText());
                city.setVisible(false);
                confirm_city.setVisible(false);
                JLabel temperature = new JLabel(OutputGiver.giveTemperature(data,description));
                JLabel weather = new JLabel(OutputGiver.giveWeather(data,description));
                temperature.setPreferredSize(new Dimension(500,100));
                weather.setPreferredSize(new Dimension(500,100));

                container.add(temperature);
                container.add(weather);
            }
        });

        setVisible(true);
    }
}
