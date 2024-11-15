package client.utils;

import client.ui.*;

import javax.swing.*;
import java.awt.*;

/**
 * Представлены методы для смены панелей во фрейме
 */

public class Utils {
    private static JPanel panelChords = new ChordsPanel().getPanel();
    private static JPanel panelSong = new SongPanel().getPanel();
    private static JPanel mainPanel = new MainPanel().getPanel();
    private static JPanel DetailsSongPanel = new DetailsSongPanel().getPanel("");
    private static JFrame frame = new BaseFrame().getFrame();

    public void openMainPanel() {
        DetailsSongPanel.setVisible(false);
        panelSong.setVisible(false);
        panelChords.setVisible(false);
        mainPanel.setVisible(true);
        frame.getContentPane().add(mainPanel, BorderLayout.SOUTH);
    }

    public void OpenSongPanel() {
        DetailsSongPanel.setVisible(false);
        mainPanel.setVisible(false);
        panelChords.setVisible(false);
        panelSong.setVisible(true);
        frame.getContentPane().add(panelSong);
    }

    public void OpenChordPanel() {
        DetailsSongPanel.setVisible(false);
        panelSong.setVisible(false);
        mainPanel.setVisible(false);
        panelChords.setVisible(true);
        frame.getContentPane().add(panelChords);
    }

    public void OpenDetailsSongPanel() {
        panelSong.setVisible(false);
        mainPanel.setVisible(false);
        panelChords.setVisible(false);
        DetailsSongPanel.setVisible(true);
        frame.getContentPane().add(DetailsSongPanel);
    }

}
