import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Frame extends JFrame {
    private final static String DEGREE  = "\u00b0";
    Frame(){
        super("Weather Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocation(50,50);
        add(new AskPanel(this));

        setVisible(true);
    }
}