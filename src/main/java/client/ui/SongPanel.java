package client.ui;


import client.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

/**
 * Панель списка доступных песен
 */

public class SongPanel {
    private static JPanel panel = new JPanel();
    protected final BaseTableModel tableModel = new BaseTableModel();
    private static Logger logger = Logger.getLogger(SongPanel.class.getName());

    public JPanel getPanel() {
        return showPanelSong();
    }

    private JPanel showPanelSong() {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new SongPanel.ButtonBackMainPanelListener());

        JTable tableSong = new JTable(tableModel);

        tableSong.setRowHeight(30);
        tableSong.setFillsViewportHeight(true);
        tableSong.setShowGrid(true);
        tableSong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    String id = String.valueOf(tableSong.getValueAt(tableSong.getSelectedRow(), 1).toString());
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

        JLabel label = new JLabel("Список доступных песен");
        JScrollPane scrollPane = new JScrollPane(tableSong);

        // Определение менеджера расположения
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                    .addComponent(backButton)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label)
                            .addComponent(scrollPane))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(backButton)
                                .addComponent(label))
                        .addComponent(scrollPane)
        );

        return panel;
    }

    public class ButtonBackMainPanelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Utils().openMainPanel();
            logger.info("Нажали кнопку возврата на главную страницу");
        }
    }
}
