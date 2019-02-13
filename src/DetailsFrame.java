import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

class DetailsFrame extends JPanel {
    private final static String DEGREE  = "\u00b0";
    DetailsFrame(JSONObject data, JSONObject description){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(600,600));

        JLabel temperature = new JLabel(OutputGiver.giveTemperature(data));
        JLabel weather = new JLabel(OutputGiver.giveWeather(description));
        temperature.setPreferredSize(new Dimension(500,25));
        weather.setPreferredSize(new Dimension(500,25));


        JButton details = new JButton("Details");
        details.setPreferredSize(new Dimension(100,25));

        JButton goBack = new JButton("Return");
        goBack.setPreferredSize(new Dimension(100,25));


        JLabel minTemperature = new JLabel("The lowest temperature in the city: "+DetailedInfo.getMinTemperature(data)+DEGREE+"C");
        minTemperature.setPreferredSize(new Dimension(500,25));
        JLabel maxTemperature = new JLabel("The highest temperature in the city: "+DetailedInfo.getMaxTemperature(data)+DEGREE+"C");
        maxTemperature.setPreferredSize(new Dimension(500,25));
        JLabel humidity = new JLabel("Humidity: "+DetailedInfo.getHumidity(data)+"%");
        humidity.setPreferredSize(new Dimension(500,25));
        JLabel pressure = new JLabel("Pressure: "+DetailedInfo.getPressure(data)+"hPa");
        pressure.setPreferredSize(new Dimension(500,25));

        add(temperature);
        add(weather);

        add(minTemperature);
        add(maxTemperature);
        add(humidity);
        add(pressure);
        add(goBack);

        goBack.addActionListener(g->{
            setVisible(false);
            new Frame();
        });
        setVisible(true);
    }
}