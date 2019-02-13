import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Frame extends JFrame {
    Frame(){
        super("Weather Checker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setLocation(0,0);
        this.add(new AskPanel(this));

        this.setVisible(true);
    }
}