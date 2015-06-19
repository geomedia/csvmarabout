/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import csvmarabout.traitement.AbstrAtraitement;
import csvmarabout.vue.FenetrePrincipale;

/**
 *
 * @author clem
 */
public class CSV implements Cloneable {

    String fichier;
    String[] entete;
//    List contenu;
    Object[][] content;  // [ligne][colonne]
    Character separateur;
    Character delimiteurChamp;
    String lineEnd;
    Character echapement;
    Boolean enteteDsPremiereLigne;

    public void lireFIchier() throws FileNotFoundException, IOException {
        CSVReader reader = new CSVReader(new FileReader(fichier), separateur, delimiteurChamp, echapement, 0);
        Integer i;
        int k;
        List<String[]> tmp = reader.readAll();
        content = new Object[tmp.size() + 1][tmp.get(0).length];

        // Découverte des entete
        if (enteteDsPremiereLigne) {
            entete = tmp.get(0);
        } else {
            entete = new String[tmp.get(0).length];
            for (i = 0; i < entete.length; i++) {
                entete[i] = i.toString();
            }
        }

//        On ajoute les combobox
        for (k = 0; k < entete.length; k++) {
            JComboBox listval = new JComboBox(Config.getInstance().getReserveTraitement().toArray());
            content[0][k] = listval;
        }

        int start = 0;
        if (enteteDsPremiereLigne) {
            start = 1;
        } else {
            start = 0;
        }


        // Pour chaque ligne
        for (i = start; i < tmp.size(); i++) {

            String[] ligne = tmp.get(i);
            int j = 0;
            while (j < entete.length) {
                content[i + 1 - start][j] = ligne[j];
                j++;
            }
        }
    }

    public String getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    public Character getEchapement() {
        return echapement;
    }

    public void setEchapement(Character echapement) {
        this.echapement = echapement;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String[] getEntete() {
        return entete;
    }

    public void setEntete(String[] entete) {
        this.entete = entete;
    }

//    public List getContenu() {
//        return contenu;
//    }
//
//    public void setContenu(List contenu) {
//        this.contenu = contenu;
//    }
    public Character getSeparateur() {
        return separateur;
    }

    public void setSeparateur(Character separateur) {
        this.separateur = separateur;
    }

    public Character getDelimiteurChamp() {
        return delimiteurChamp;
    }

    public void setDelimiteurChamp(Character delimiteurChamp) {
        this.delimiteurChamp = delimiteurChamp;
    }

    public Object[][] getContent() {
        return content;
    }

    public void setContent(String[][] content) {
        this.content = content;
    }

    public Boolean getEnteteDsPremiereLigne() {
        return enteteDsPremiereLigne;
    }

    public void setEnteteDsPremiereLigne(Boolean enteteDsPremiereLigne) {
        this.enteteDsPremiereLigne = enteteDsPremiereLigne;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CSV cloneCSV;

        cloneCSV = (CSV) super.clone();
//    content = new String[tmp.size()][entete.length];

        // On recopi le tableau dans le clone
        int i;
        int j;
        cloneCSV.content = new Object[content.length - 1][entete.length];
        for (i = 1; i < content.length; i++) {
            for (j = 0; j < entete.length; j++) {
                cloneCSV.content[i - 1][j] = content[i][j];

            }
        }
//        content = content.clone();
        return cloneCSV; //To change body of generated methods, choose Tools | Templates.
    }

    public void appliTraitement() {
//               content = new String[tmp.size()][entete.length];
        int i;
        int j;
        // Récupération des traitement dans la première ligne du tableau

        List<JComboBox> listComboBox = new ArrayList<>();
        for (i = 0; i < entete.length; i++) {
            JComboBox combo = (JComboBox) FenetrePrincipale.getInstance().getCsv().getContent()[0][i];
            AbstrAtraitement traitmeent = (AbstrAtraitement) combo.getSelectedItem();
            // On applique le traitement sur les lignes
            for (j = 0; j < content.length; j++) {
                String contenuModifie = (String) content[j][i];
                try {
                    contenuModifie = traitmeent.executer((String) content[j][i]);
                } catch (Exception ex) {
                    Logger.getLogger(CSV.class.getName()).log(Level.SEVERE, null, ex);
                }
                content[j][i] = contenuModifie;
            }
        }
    }

    /**
     * *
     * Ecrit le fichier dans le fichier csv envoyé en argument.
     *
     * @param file
     */
    public void writetoFile(String file) throws IOException {
        CSVWriter cSVWriter = genererCSVWriter(new FileWriter(file));
        List<String[]> resuEnregistre = new ArrayList<>();
        try {

            // enregistrement de l'entete
            if (this.getEnteteDsPremiereLigne()) {
                resuEnregistre.add(this.getEntete());
            }

            for (int i = 0; i < this.getContent().length; i++) {
                String[] ligne = new String[this.getEntete().length];
                for (int j = 0; j < this.getEntete().length; j++) {
                    ligne[j] = (String) this.getContent()[i][j];
                }
                resuEnregistre.add(ligne);
            }
            cSVWriter.writeAll(resuEnregistre);

        } catch (Exception e) {
        } finally {

            cSVWriter.close();
        }
    }

    /**
     * *
     * Configure et génrère un CSVWriter a partir des information (separator delimitateur etc...
     *
     * @return
     */
    public CSVWriter genererCSVWriter(FileWriter fw) {
        if (this.separateur != null) {
            if (this.delimiteurChamp != null) {
                if (this.lineEnd == null && this.echapement != null) {
                    System.out.println("return new CSVWriter(fw, separateur, delimiteurChamp, echapement, lineEnd);");
                    return new CSVWriter(fw, separateur, delimiteurChamp, echapement);
                }
                
//                else if (this.lineEnd == null && this.echapement != null) {
//                    System.out.println(" return new CSVWriter(fw, separateur, delimiteurChamp, echapement);");
//                    return new CSVWriter(fw, separateur, delimiteurChamp, echapement);
//                }
                
                else if (this.lineEnd != null && !this.lineEnd.isEmpty() && this.echapement == null) {
                    System.out.println("return new CSVWriter(fw, separateur, delimiteurChamp, echapement, lineEnd);");
    
                    return new CSVWriter(fw, separateur, delimiteurChamp);
                }
                else{
                    System.out.println(" return new CSVWriter(fw, separateur, delimiteurChamp, lineEnd);        ");
//                return new CSVWriter(fw, separateur, delimiteurChamp, lineEnd);         
                                    System.out.println("lineEnd" + lineEnd);
                                   
                return new CSVWriter(fw, separateur, delimiteurChamp);                    
                }
            }
            System.out.println(" return new CSVWriter(fw, separateur);");
            return new CSVWriter(fw, separateur);
        }
        System.out.println("return new CSVWriter(fw);");
        return new CSVWriter(fw);
    }
    
    

}
