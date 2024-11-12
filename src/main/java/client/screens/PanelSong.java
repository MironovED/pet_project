package client.screens;


import client.ClientManager;
import client.utils.Utils;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Реализация панели списка доступных песен
 */

public class PanelSong {
    private static JPanel panel = new JPanel();
    private static String[] columnsName = new String[]{"Исполнитель", "Название песни", "Ссылка"};
    private static String[][] songs = new ClientManager().getSongs();
    protected final SongTableModel tableModel = new SongTableModel();


    public JPanel getPanel() {
        return showPanelSong(songs, columnsName);
    }

    private JPanel showPanelSong(String[][] song, String[] columnsName) {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new PanelSong.ButtonBackMainPanelListener());
        panel.add(backButton);
        JTable tableSong = new JTable(song, columnsName);
        tableSong.setRowHeight(80);
        tableSong.setFillsViewportHeight(true);
        tableSong.setShowGrid(true);
        tableSong.setGridColor(Color.RED);
        tableSong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Просто клик по строке");
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Двойной клик по строке");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

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

    public class SongTableModel extends AbstractTableModel {
        private final String[] columnsName = {"Исполнитель", "Название песни", "Ссылка"};
        private Object[][] songs = new ClientManager().getSongs();

        @Override
        public int getRowCount() {
            return songs.length;
        }

        @Override
        public int getColumnCount() {
            return columnsName.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }

        @Override
        public boolean isCellEditable(int row, int column) { return false; }

        public void setValueAt(Object value, int row, int col) {
            songs[row][col] = value;
            fireTableCellUpdated(row, col);
        }

    }
}
