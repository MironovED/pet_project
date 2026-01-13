package client.ui;

import client.ClientManager;
import org.json.JSONObject;
import server.ServerManager;
import songrepo.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFrame {
    private JFrame frame = new JFrame("Добавление песни");
    private static JTextField authorField = new JTextField();
    private static JTextField titleField = new JTextField();
    private static JTextField linkField = new JTextField();
    private static JTextArea textField = new JTextArea();

    public JFrame getFrame(){
        return frame;
    }

    public void showCreatePanel() {
        JPanel panel = new JPanel();

        JLabel authorLabel = new JLabel("Автор:");
        JLabel titleLabel = new JLabel("Название песни:");
        JLabel linkLabel = new JLabel("Ссылка:");
        JLabel textLabel = new JLabel("Текст:");


        JScrollPane scrollPane = new JScrollPane(textField);
        JButton button = new JButton("Добавить песню");
        button.addActionListener(new ButtonCreate());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(authorLabel)
                                .addComponent(titleLabel)
                                .addComponent(linkLabel)
                                .addComponent(textLabel)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(authorField)
                                .addComponent(titleField)
                                .addComponent(linkField)
                                .addComponent(scrollPane)
                                .addComponent(button)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(authorLabel)
                                .addComponent(authorField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(titleLabel)
                                .addComponent(titleField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(linkLabel)
                                .addComponent(linkField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textLabel)
                                .addComponent(scrollPane)
                        )
                        .addComponent(button)
        );

        frame.getContentPane().add(panel);
        frame.setSize(500, 600);
        frame.setLocation(550, 100);
        frame.setVisible(true);
    }

    public class ButtonCreate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String author = authorField.getText();
            String title = titleField.getText();
            String text = textField.getText();
            String link = linkField.getText();

            if (author.equals("") || title.equals("") || text.equals("") || link.equals("")) {
                JOptionPane.showMessageDialog(frame, "Все поля должны быть заполнены!");
            } else {
                JSONObject newJO = ServerManager.createJson(author, title, text, link);

                try {
                    String fileName = "src/main/resources/song/" + title + ".json";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    writer.write(newJO.toString());
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Песня добавлена!");
                    frame.setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                authorField.setText("");
                titleField.setText("");
                textField.setText("");
                linkField.setText("");
            }
        }
    }
}
