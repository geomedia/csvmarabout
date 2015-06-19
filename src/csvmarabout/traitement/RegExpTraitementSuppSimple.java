/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.traitement;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author clem
 */
public class RegExpTraitementSuppSimple extends AbstrAtraitement {

    Boolean supprimer;
    String regExp;

    @Override
    public String executer(String entre) throws Exception {

        Pattern p = Pattern.compile(regExp);

        Matcher m = p.matcher(entre);

        if (supprimer) {
            return entre.replaceAll(regExp, "");
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            String test = "Ici c'est un test. Article en rapport blabla en Syrie. Par clem";

            RegExpTraitementSuppSimple traitement = new RegExpTraitementSuppSimple();
            traitement.setSupprimer(Boolean.TRUE);
            traitement.setRegExp("(Article en rapport.*)Par");

            System.out.println("result " + traitement.executer(test));
        } catch (Exception ex) {
            Logger.getLogger(RegExpTraitementSuppSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public String getRegExp() {
        return regExp;
    }

    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }
}
