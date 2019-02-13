import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AskPanel extends JPanel {
    AskPanel(JFrame frame){

        setLayout(new FlowLayout());

        JTextField city = new JTextField();
        city.setPreferredSize(new Dimension(500,25));
        ArrayList<String> words = cityList.getList();
        AutoSuggestor autoSuggestor = new AutoSuggestor(city, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {
                setDictionary(words);
                return super.wordTyped(typedWord);
            }
        };
        JButton confirm_city = new JButton("Confirm");
        confirm_city.setPreferredSize(new Dimension(100,25));

        add(city);
        add(confirm_city);
        confirm_city.addActionListener(e -> {
            if(OutputGiver.getData(city.getText()).length()!=0){
                add(new BasicFrame(city));
                city.setVisible(false);
                confirm_city.setVisible(false);
            }
        });
    }
}