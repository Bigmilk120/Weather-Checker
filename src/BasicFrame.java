import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class BasicFrame extends JPanel{
    private final static String DEGREE  = "\u00b0";
    BasicFrame(JTextField city){
        setPreferredSize(new Dimension(600,400));
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
            add(new DetailsFrame(data));
            details.setVisible(false);
            setVisible(true);
        });
        goBack.addActionListener(g ->{
            setVisible(false);
            add(new AskPanel((JFrame)this.getTopLevelAncestor()));
        });
    }
}
