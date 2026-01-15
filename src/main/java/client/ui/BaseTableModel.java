package client.ui;

import client.ClientManager;

import javax.swing.table.AbstractTableModel;

/**
 * Базовая модель таблицы
 */
public class BaseTableModel extends AbstractTableModel {
    private final String[] columnsName = {"Исполнитель", "Песня", "Ссылка"};
    private static Object[][] songs;

    public BaseTableModel() {
        songs = ClientManager.getSongs();
    }

    public static void updateSongs() {
        songs = ClientManager.getSongs();
    }

    @Override
    public int getRowCount() {
        return songs.length;
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public Object getValueAt(int row, int col) { return songs[row][col]; }

    @Override
    public boolean isCellEditable(int row, int column) { return false; }

    @Override
    public String getColumnName(int column) { return columnsName[column]; }

    public void setValueAt(Object value, int row, int col) {
        songs[row][col] = value;
        fireTableCellUpdated(row, col);
        fireTableDataChanged();
    }
}
