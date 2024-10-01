package client.screens;

import client.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Реализация панели с аккордами
 */

public class PanelChords {
    private static JPanel panel = new JPanel();

    public JPanel getPanel() {
        return showPanelChords();
    }

    private JPanel showPanelChords() {
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new PanelChords.ButtonBackMainPanelListener());
        panel.add(backButton);

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
