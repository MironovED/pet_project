package client.utils;

import client.screens.MainPanel;
import client.screens.MainScreen;
import client.screens.PanelChords;
import client.screens.PanelSong;

import javax.swing.*;

/**
 * В данном классе представлены методы для смены панелей во фрейме
 */

public class Utils {
    private static JPanel panelChords = new PanelChords().getPanel();
    private static JPanel panelSong = new PanelSong().getPanel();
    private static JPanel mainPanel = new MainPanel().getPanel();
    private static JFrame frame = new MainScreen().getFrame();

    public void openMainPanel() {
        panelSong.setVisible(false);
        panelChords.setVisible(false);
        mainPanel.setVisible(true);
        frame.getContentPane().add(mainPanel);
    }

    public void OpenSongPanel() {
        mainPanel.setVisible(false);
        panelChords.setVisible(false);
        panelSong.setVisible(true);
        frame.getContentPane().add(panelSong);
    }

    public void OpenChordPanel() {
        panelSong.setVisible(false);
        mainPanel.setVisible(false);
        panelChords.setVisible(true);
        frame.getContentPane().add(panelChords);
    }
}
