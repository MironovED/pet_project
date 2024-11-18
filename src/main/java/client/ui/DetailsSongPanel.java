package client.ui;

import client.ClientManager;
import client.utils.Utils;
import songrepo.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Детальный экран выбранной песни
 */
public class DetailsSongPanel {
    private static JPanel panel = new JPanel();
    private static String idRow;

    public DetailsSongPanel(String idRow) {
        this.idRow = idRow;
    }

    public JPanel getPanel() {
        return showPanel();
    }

    private JPanel showPanel() {
        Song song = new ClientManager().findSong(idRow);

        JTextArea text = new JTextArea(song.getText());
        JTextField link = new JTextField(song.getYandexLink());

        JButton buttonBack = new JButton("назад");
        buttonBack.addActionListener(new ButtonBackListener());

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JScrollPane(text));
        panel.add(new JScrollPane(link));
        panel.add(buttonBack);

        return panel;
    }

    public class ButtonBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            panel.setVisible(false);
            panel.removeAll();
            new Utils().OpenSongPanel();
            System.out.println("Нажали на кнопку возврата на страницу песен");
        }
    }
}


