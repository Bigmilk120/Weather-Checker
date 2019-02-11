import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Frame extends JFrame {
    Frame(){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocation(50,50);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        setLayout(new FlowLayout());
        ArrayList<String> words =cityList.getList();

        JTextField city = new JTextField();
        city.setPreferredSize(new Dimension(500,25));

        AutoSuggestor autoSuggestor = new AutoSuggestor(city, this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {

                setDictionary(words);
                return super.wordTyped(typedWord);
            }
        };


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

            JButton details = new JButton("Details");
            details.setPreferredSize(new Dimension(100,25));

            details.addActionListener(d ->{
                new DetailsFrame(data);
            });

            city.setVisible(false);
            confirm_city.setVisible(false);

            container.add(temperature);
            container.add(weather);
            container.add(details);
        });

        setVisible(true);
    }
}