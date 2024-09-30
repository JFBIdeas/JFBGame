package jfb.view;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("JFB Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PaintPanel paintPanel = new PaintPanel();
        setContentPane(paintPanel);


        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void update(){

    }

    public void paint (Graphics2D g){

    }
}
