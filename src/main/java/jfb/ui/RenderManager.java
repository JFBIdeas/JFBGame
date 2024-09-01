package jfb.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderManager {

    public void repaint(Graphics2D g2) {

    }

    public void drawImage(Graphics2D g2, BufferedImage image, int x, int y, int width, int height) {

    }

    public void clearImage(BufferedImage image) {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
    }
}