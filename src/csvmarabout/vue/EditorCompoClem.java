/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.vue;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author clem
 */
public class EditorCompoClem extends DefaultCellEditor {

    public EditorCompoClem(JTextField textField) {
        super(textField);
    }

    public EditorCompoClem(JCheckBox checkBox) {
        super(checkBox);
    }

    public EditorCompoClem(JComboBox comboBox) {
        super(comboBox);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        if (row == 0) {
            
            JComboBox tmpCombo = (JComboBox) value;
            
//            String[] val = new String[]{"a","b"};
            
            DefaultCellEditor cellEditor = new DefaultCellEditor(tmpCombo);
            return cellEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
//            super.getTableCellEditorComponent(table, value, isSelected, row, column);

        } else {

            DefaultCellEditor cellEditor = new DefaultCellEditor(new JTextField());
            return cellEditor.getTableCellEditorComponent(table, value, isSelected, row, column);

        }


    }
}
