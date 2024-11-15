package client.ui;

import client.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Главная панель
 * На ней располагаются 2 кнопки
 */

public class MainPanel extends JPanel {
    private static JPanel panel = new JPanel();

    public JPanel getPanel() {
        return showMainPanel();
    }

    private JPanel showMainPanel() {
        JButton openSongs = new JButton("Открыть список песен");
        openSongs.addActionListener(new MainPanel.ButtonOpenSongListener());
        openSongs.setSize(100, 500);
        openSongs.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton openChords = new JButton("Открыть аккорды");
        openChords.addActionListener(new MainPanel.ButtonOpenChordListener());
        openChords.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(openSongs);
        panel.add(openChords);
        panel.setSize(new Dimension(500, 200));
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
