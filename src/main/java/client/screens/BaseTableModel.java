package client.screens;

import javax.swing.table.AbstractTableModel;

/**
 * Базовая модель таблицы
 */
public abstract class BaseTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
       return getRowCount();
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }


}
