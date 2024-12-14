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
        JLabel label = new JLabel(song.getAuthor() + " - " + song.getTitle());

        JTextArea text = new JTextArea(song.getText());
        text.setEditable(false);
        JScrollPane textPane = new JScrollPane(text);

        JTextField link = new JTextField(song.getLink());
        link.setEditable(false);

        JButton buttonBack = new JButton("Назад");
        buttonBack.addActionListener(new ButtonBackListener());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(buttonBack)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(label)
                                .addComponent(textPane)
                                .addComponent(link))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonBack)
                                .addComponent(label))
                        .addComponent(textPane)
                        .addComponent(link)
        );

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


