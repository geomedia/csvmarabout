/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.traitement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clem
 */
public class RechercherRemplacerSimple extends TraitementComportement{
    
    List<String[]> listExpression;

    public RechercherRemplacerSimple() {
        listExpression = new ArrayList<>();
    }
    

    @Override
    public String executer(String entre) throws Exception {
        int i;
        for(i=0;i<listExpression.size();i++)
        {
            entre = entre.replaceAll(listExpression.get(i)[0], listExpression.get(i)[1]);
        }        
        return entre;
    }

    public List<String[]> getListExpression() {
        return listExpression;
    }

    public void setListExpression(List<String[]> listExpression) {
        this.listExpression = listExpression;
    }
}
