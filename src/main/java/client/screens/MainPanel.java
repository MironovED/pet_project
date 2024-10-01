package client.screens;

import client.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Реализация главной панели фрейма
 */

public class MainPanel {
    private static JPanel panel = new JPanel();

    public JPanel getPanel() {
        return showMainPanel();
    }

    private JPanel showMainPanel() {
        panel.setLayout(new GridBagLayout());

        JButton openSongs = new JButton("Открыть список песен");
        openSongs.addActionListener(new MainPanel.ButtonOpenSongListener());

        JButton openChords = new JButton("Открыть аккорды");
        openChords.addActionListener(new MainPanel.ButtonOpenChordListener());

        panel.setLayout(new GridBagLayout());
        panel.add(openSongs);
        panel.add(openChords);

        return panel;
    }

    public class ButtonOpenSongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().OpenSongPanel();
            System.out.println("Нажали на кнопку открытия списка песен");
        }
    }

    public class ButtonOpenChordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().OpenChordPanel();
            System.out.println("Пока нет события на кнопку открыть аккорды");
        }
    }
}
