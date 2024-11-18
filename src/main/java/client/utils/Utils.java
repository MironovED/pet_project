package client.utils;

import client.ui.BaseFrame;
import client.ui.ChordsPanel;
import client.ui.MainPanel;
import client.ui.SongPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Представлены методы для смены панелей во фрейме
 */
public class Utils {
    private static JPanel panelChords = new ChordsPanel().getPanel();
    private static JPanel panelSong = new SongPanel().getPanel();
    private static JPanel mainPanel = new MainPanel().getPanel();
    private static JFrame frame = new BaseFrame().getFrame();

    public void openMainPanel() {
        panelSong.setVisible(false);
        panelChords.setVisible(false);
        mainPanel.setVisible(true);
        frame.getContentPane().add(mainPanel, BorderLayout.SOUTH);
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

    public void OpenDetailsSongPanel(JPanel panel) {
        panelSong.setVisible(false);
        mainPanel.setVisible(false);
        panelChords.setVisible(false);
        panel.setVisible(true);
        frame.getContentPane().add(panel);
    }
}
