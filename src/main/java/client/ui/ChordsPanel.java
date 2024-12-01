package client.ui;

import client.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Панель с аккордами
 */

public class ChordsPanel {
    private static JPanel panel = new JPanel();

    public JPanel getPanel() {
        return showPanelChords();
    }

    private JPanel showPanelChords() {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new ChordsPanel.ButtonBackMainPanelListener());

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        //автоматическая вставка разрыва
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Создание горизонтальной группы
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(backButton));

        layout.linkSize(SwingConstants.HORIZONTAL, backButton);

        // Создание вертикальной группы
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(backButton)));

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
