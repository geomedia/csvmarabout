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
public class TraitementComportement extends AbstrAtraitement{
    
    private String nom;
    

    private List<AbstrAtraitement> listTraitement = new ArrayList<>();

    public TraitementComportement() {
        listTraitement = new ArrayList<AbstrAtraitement>();
    }

    public List<AbstrAtraitement> getListTraitement() {
        return listTraitement;
    }

    public void setListTraitement(List<AbstrAtraitement> listTraitement) {
        this.listTraitement = listTraitement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        
        if(this.nom!=null){
            return this.nom;
        }
        else{
            return "Compo";
        }
        
        
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executer(String entre) throws Exception {
        String resu=entre;
        int i;
        for(i=0;i<listTraitement.size();i++){
            resu = listTraitement.get(i).executer(resu);
        }
        return resu;
    }
    
}
