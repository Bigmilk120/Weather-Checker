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
        setSize(600,600);
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
            container.add(new BasicFrame(city));
            city.setVisible(false);
            confirm_city.setVisible(false);
        });

        setVisible(true);
    }
}