/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.traitement;

/**
 *
 * @author clem
 */
public abstract class AbstrAtraitement {
    
    private String nom;
    
    
    public abstract String executer(String entre) throws Exception;

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
            return "Comportement non nommé";
                    
        }
    }
    
    
    
    
    
}
