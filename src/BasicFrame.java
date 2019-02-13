import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class BasicFrame extends JPanel{
    private final static String DEGREE  = "\u00b0";
    BasicFrame(JTextField city){
        setPreferredSize(new Dimension(600,600));
        setLayout(new FlowLayout());


        JSONObject data = OutputGiver.getData(city.getText());
        JSONObject description = OutputGiver.getDescription(city.getText());

        JLabel temperature = new JLabel(OutputGiver.giveTemperature(data));
        JLabel weather = new JLabel(OutputGiver.giveWeather(description));
        temperature.setPreferredSize(new Dimension(500,25));
        weather.setPreferredSize(new Dimension(500,25));

        JButton details = new JButton("Details");
        details.setPreferredSize(new Dimension(100,25));

        JButton goBack = new JButton("Return");
        goBack.setPreferredSize(new Dimension(100,25));


        add(temperature);
        add(weather);
        add(details);
        add(goBack);
        details.addActionListener(d ->{
            temperature.setVisible(false);
            weather.setVisible(false);
            details.setVisible(false);
            goBack.setVisible(false);
            add(new DetailsFrame(data, description));
        });
        goBack.addActionListener(g ->{
            setVisible(false);
            //add(new AskPanel((JFrame) SwingUtilities.getWindowAncestor(this)));
            new Frame();

        });
    }
}
