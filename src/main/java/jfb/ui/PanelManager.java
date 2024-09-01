package jfb.ui;

import javax.swing.*;

public class PanelManager {
    private GamePanel basicGamePanel;

    public PanelManager() {
        basicGamePanel = new GamePanel();
    }

    public JPanel getBasicGamePanel() {
        return basicGamePanel;
    }
}
