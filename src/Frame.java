import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Frame extends JFrame {
    private final static String DEGREE  = "\u00b0";
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
        ArrayList<String> words = cityList.getList();
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
            temperature.setPreferredSize(new Dimension(500,25));
            weather.setPreferredSize(new Dimension(500,25));
            JLabel minTemperature = new JLabel("The lowest temperature in the city: "+DetailedInfo.getMinTemperature(data)+DEGREE+"C");
            minTemperature.setPreferredSize(new Dimension(250,25));
            JLabel maxTemperature = new JLabel("The highest temperature in the city: "+DetailedInfo.getMaxTemperature(data)+DEGREE+"C");
            maxTemperature.setPreferredSize(new Dimension(250,25));
            JLabel humidity = new JLabel("Humidity: "+DetailedInfo.getHumidity(data)+"%");
            humidity.setPreferredSize(new Dimension(250,25));
            JLabel pressure = new JLabel("Pressure: "+DetailedInfo.getPressure(data)+"hPa");
            pressure.setPreferredSize(new Dimension(250,25));

            JButton details = new JButton("Details");
            details.setPreferredSize(new Dimension(100,25));

            city.setVisible(false);
            confirm_city.setVisible(false);

            container.add(temperature);
            container.add(weather);
            container.add(details);

            details.addActionListener(d ->{
                details.setVisible(false);
                container.add(minTemperature);
                container.add(maxTemperature);
                container.add(humidity);
                container.add(pressure);
                container.setVisible(true);
            });



        });

        setVisible(true);
    }
}