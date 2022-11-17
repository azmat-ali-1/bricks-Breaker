
import java.awt.Component;

import javax.swing.JFrame;

public class Main {
    private static final Component GAme = null;

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GAme gamePlay = new GAme();

        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        obj.setVisible(true);
        obj.add(gamePlay);
        }

    }