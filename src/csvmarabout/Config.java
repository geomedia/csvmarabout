/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout;

import java.util.ArrayList;
import java.util.List;
import csvmarabout.traitement.HTMLTraitement;
import csvmarabout.traitement.RechercherRemplacerSimple;
import csvmarabout.traitement.TraitementComportement;

/**
 *
 * @author clem
 */
public class Config {

    List<TraitementComportement> reserveTraitement;
    private static Config instance;

    private Config() {
        reserveTraitement = new ArrayList<>();

        // Inci on configure des traitement de base avant de pouvoir le faire graphiquement.

        // Comportement null
        TraitementComportement comportement1 = new TraitementComportement();
        comportement1.setNom("Aucun");


        //CONFIG LE MONDE
        TraitementComportement comportement2 = new TraitementComportement();
        comportement2.setNom("Traitement de base");



//        HTMLTraitement hTMLTraitement = new HTMLTraitement();
//        comportement2.getListTraitement().add(hTMLTraitement);
//        hTMLTraitement.setAplatirHTML(Boolean.TRUE);
//        hTMLTraitement.setSuppHTMLEntities(Boolean.TRUE);
//        hTMLTraitement.setNom("Traitement de base");

        // Du rechercher remplacer pour les problèmes de caractères
        RechercherRemplacerSimple rechercherRemplacer = new RechercherRemplacerSimple();
        comportement2.getListTraitement().add(rechercherRemplacer);
        rechercherRemplacer.getListExpression().add(new String[]{"Ã©", "é"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã‰", "É"});
        rechercherRemplacer.getListExpression().add(new String[]{"ÃŠ", "È"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¨", "è"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ãª", "ê"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã«", "ë"});
        
        rechercherRemplacer.getListExpression().add(new String[]{"Ã®", "î"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¯", "ï"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã", "Ï"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã§", "ç"});
        
        rechercherRemplacer.getListExpression().add(new String[]{"Ã ", "à"});
        rechercherRemplacer.getListExpression().add(new String[]{"à¢", "â"});
        
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¢", "Â"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã€", "À"});

        rechercherRemplacer.getListExpression().add(new String[]{"â€¦", "…"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¹", "ù"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã»", "û"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¼", "ü"});

        //guillemet francais
        rechercherRemplacer.getListExpression().add(new String[]{"Â«", "\""});
        rechercherRemplacer.getListExpression().add(new String[]{"Â»", "\""});
        rechercherRemplacer.getListExpression().add(new String[]{"â€™", "'"});
        
        rechercherRemplacer.getListExpression().add(new String[]{"à´", "ô"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã´", "ô"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã¶", "ö"});
        
        rechercherRemplacer.getListExpression().add(new String[]{"â€“", "–"});
        rechercherRemplacer.getListExpression().add(new String[]{"â€”", "—"});
        
        
        rechercherRemplacer.getListExpression().add(new String[]{"Å“", "œ"});
        rechercherRemplacer.getListExpression().add(new String[]{"Ã£", "ã"}); // Comme São Polo
        rechercherRemplacer.getListExpression().add(new String[]{"â€œ", "“"}); // Comme São Polo
        rechercherRemplacer.getListExpression().add(new String[]{"â€", "”"}); // Comme São Polo
        rechercherRemplacer.getListExpression().add(new String[]{"Â½", "½"}); // Comme São Polo
        rechercherRemplacer.getListExpression().add(new String[]{"â€˜", "‘"}); // Comme São Polo
        
        




        reserveTraitement.add(comportement1);
        reserveTraitement.add(comportement2);

    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public List<TraitementComportement> getReserveTraitement() {
        return reserveTraitement;
    }

    public void setReserveTraitement(List<TraitementComportement> reserveTraitement) {
        this.reserveTraitement = reserveTraitement;
    }
}
