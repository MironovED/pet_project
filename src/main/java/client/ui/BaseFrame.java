package client.ui;

import client.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Базовое окно
 */

public class BaseFrame extends Frame {
    private static JFrame frame = new JFrame("Песни под гитару");

    public JFrame getFrame() {
        return frame;
    }

    public void start() {
        setMenu();
        new Utils().openMainPanel();
        setFrame();
    }

    public void setFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLocation(400, 100);
        frame.setVisible(true);
    }

    public void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню");
        JMenuItem addSong = new JMenuItem("Добавить песню");
        addSong.addActionListener(new BaseFrame.AddSongListener());
        JMenuItem remoteSong = new JMenuItem("Удалить песню");
        remoteSong.addActionListener(new BaseFrame.RemoteSongListener());

        menu.add(addSong);
        menu.add(remoteSong);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
    }

    public class AddSongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Пока нет события на кнопку меню добавить песню");
        }
    }

    public class RemoteSongListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Пока нет события на кнопку меню удалить песню");
        }
    }
}
