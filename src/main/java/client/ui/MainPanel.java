package client.ui;

import client.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Главная панель
 * На ней располагаются 2 кнопки
 */
public class MainPanel extends JPanel {
    private static JPanel panel = new JPanel();
    private static Logger logger = Logger.getLogger(MainPanel.class.getName());

    public JPanel getPanel() {
        return showMainPanel();
    }

    private JPanel showMainPanel() {
        JButton openSongs = new JButton("Список песен");
        openSongs.addActionListener(new MainPanel.ButtonOpenSongListener());

        JButton openChords = new JButton("Аккорды");
        openChords.addActionListener(new MainPanel.ButtonOpenChordListener());

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                        .addComponent(openSongs)
                        .addComponent(openChords)));

        layout.linkSize(SwingConstants.HORIZONTAL, openSongs, openChords);

        // Создание вертикальной группы
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                                .addComponent(openSongs)
                                .addComponent(openChords));

        return panel;
    }

    public class ButtonOpenSongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().OpenSongPanel();
            logger.info("Нажали кнопку открытия списка песен");
        }
    }

    public class ButtonOpenChordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().OpenChordPanel();
            logger.info("Нажали кнопку открыть аккорды");
        }
    }
}
