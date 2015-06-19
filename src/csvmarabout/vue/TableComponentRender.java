/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.vue;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author clem
 */
public class TableComponentRender extends DefaultTableCellRenderer {
    
    JComboBox jComboBox = new JComboBox();
    

    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Si la valeur de la cellule est un JButton, on transtype cette valeur
    if(row==0){
        //recup del a valeur
        JComboBox tmpCombo =(JComboBox) value;
//        String s = (String) tmpCombo.getSelectedItem();
////        String[] listval = tmpCombo
//        
//        jComboBox= new JComboBox(new Object[]{"a","b"});
        
    
        return tmpCombo;
    } 
//    else{
        this.setText((String) value);
        
        return this;
//    }
    
        
//        if (value instanceof String) {
//            JButton button = new JButton("toto");
//                    return button;
////            return (JButton) value;
//        } else {
//            return this;
//        }
    }
    
    class JComboboxLisner implements ItemListener, MouseListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("click");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("click");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("click");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("click");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("click");
        }

    }
    
}
