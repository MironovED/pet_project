package client.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveFrame {
    private JFrame frame = new JFrame("Удаление песни");
    protected BaseTableModel tableModel = new BaseTableModel();

    public JFrame getFrame() {return frame;}

    public void showRemovePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Выберите песню");
        JTable table = new JTable(tableModel);
        JButton button = new JButton("Удалить песню");
        JScrollPane scrollPane = new JScrollPane(table);

        button.addActionListener(new ButtonRemove());
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(label)
                                .addComponent(scrollPane)
                                .addComponent(button)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(label)
                        .addComponent(scrollPane)
                        .addComponent(button)
        );

        frame.getContentPane().add(panel);
        frame.setSize(500, 600);
        frame.setLocation(550, 100);
        frame.setVisible(true);
    }

    public class ButtonRemove implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
