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
        //openSongs.setSize(100, 500);

        JButton openChords = new JButton("Открыть аккорды");
        openChords.addActionListener(new MainPanel.ButtonOpenChordListener());

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(openSongs)
                .addComponent(openChords));

        layout.linkSize(SwingConstants.HORIZONTAL, openSongs, openChords);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(openSongs)
                        .addComponent(openChords)));

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
