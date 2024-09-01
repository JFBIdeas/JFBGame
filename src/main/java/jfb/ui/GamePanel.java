package jfb.ui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    RenderManager render;

    public GamePanel() {
        render = new RenderManager();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render.repaint((Graphics2D) g);
    }
}
