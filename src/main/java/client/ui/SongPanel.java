package client.ui;


import client.utils.Utils;
import songrepo.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


/**
 * Панель списка доступных песен
 */

public class SongPanel {
    private static JPanel panel = new JPanel();
    protected final BaseTableModel tableModel = new BaseTableModel();

    public JPanel getPanel() {
        return showPanelSong();
    }

    private JPanel showPanelSong() {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new SongPanel.ButtonBackMainPanelListener());
        panel.add(backButton);
        JTable tableSong = new JTable(tableModel);
        tableSong.setRowHeight(80);
        tableSong.setFillsViewportHeight(true);
        tableSong.setShowGrid(true);
        tableSong.setGridColor(Color.RED);
        tableSong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Двойной клик по строке");
                    String id = String.valueOf(tableSong.getValueAt(tableSong.getSelectedRow(), 1).toString());
                    System.out.println(id);
                    JPanel detailsPanel = new DetailsSongPanel(id).getPanel();
                    new Utils().OpenDetailsSongPanel(detailsPanel);
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


}
