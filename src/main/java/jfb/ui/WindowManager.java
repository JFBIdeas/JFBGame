package jfb.ui;

import javax.swing.*;

public class WindowManager {
    private JFrame gameFrame;
    private PanelManager panelManager;

    public WindowManager() {
        panelManager = new PanelManager();
        gameFrame = new JFrame();
        gameFrame.add(panelManager.getBasicGamePanel());
    }
}
