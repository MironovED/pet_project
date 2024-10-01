package client.screens;

import client.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Реализация панели списка доступных песен
 */

public class PanelSong {
    private static JPanel panel = new JPanel();
    String [][] song = new String[][]
            {{"Song 1", "autor 1", "link 1"},
                    {"Song 2", "autor 2", "link 2"},
                    {"Song 3", "autor 3", "link 3"},
                    {"Song 4", "autor 4", "link 4"},
                    {"Song 5", "autor 5", "link 5"}};
    String [] columnsName = new String[] {"Name","Autor","Link"};

    public JPanel getPanel() {
        return showPanelSong(song, columnsName);
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
