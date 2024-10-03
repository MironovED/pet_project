package client.screens;


import client.ClientManager;
import client.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Реализация панели списка доступных песен
 */

public class PanelSong {
    private static JPanel panel = new JPanel();
    private static String[] columnsName = new String[]{"Исполнитель", "Название песни", "Ссылка"};
    private static String[][] songs = new ClientManager().getSongs();

    public JPanel getPanel() {
        return showPanelSong(songs, columnsName);
    }

    private JPanel showPanelSong(String[][] song, String[] columnsName) {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new PanelSong.ButtonBackMainPanelListener());
        panel.add(backButton);
        JTable tableSong = new JTable(song, columnsName);
        tableSong.setRowHeight(80);
        panel.add(new JScrollPane(tableSong));

        return panel;
    }

    public class ButtonBackMainPanelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().openMainPanel();
            System.out.println("Нажали на кнопку возврата на главную страницу");
        }
    }
}
