package csvmarabout.vue;


import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clem
 */
public class ZModel extends AbstractTableModel {

    private Object[][] data;
    private String[] title;

    //Constructeur
    public ZModel(Object[][] data, String[] title) {
        this.data = data;
        this.title = title;
    }

    //Retourne le nombre de colonnes
    public int getColumnCount() {
        return this.title.length;
    }

    //Retourne le nombre de lignes
    public int getRowCount() {
        return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    public Class getColumnClass(int col) {
        //On retourne le type de la cellule à la colonne demandée
        //On se moque de la ligne puisque les types de données sont les mêmes quelle que soit la ligne
        //On choisit donc la première ligne

        return this.data[0][col].getClass();
    }
    
    
    
    
    //Retourne vrai si la cellule est éditable : celle-ci sera donc éditable
public boolean isCellEditable(int row, int col){
  return true; 
}

}
