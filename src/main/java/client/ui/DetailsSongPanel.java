package client.ui;

import client.ClientManager;
import client.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsSongPanel {
    private static JPanel panel = new JPanel();
    private Object[][] songs = new ClientManager().getSongs();

    public JPanel getPanel(String nameSong) {
        return showPanel(nameSong);
    }

    private JPanel showPanel(String nameSong) {
        JTextArea text = new JTextArea("передаем текст песни из объекта");

        JTextField link = new JTextField("передаем ссылку из объекта");

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
            new Utils().OpenSongPanel();
            System.out.println("Нажали на кнопку возврата на страницу песен");
        }
    }
}


