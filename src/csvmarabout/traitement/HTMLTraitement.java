/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.traitement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author clem
 */
public class HTMLTraitement extends AbstrAtraitement {

    Boolean suppHTMLEntities;
    Boolean aplatirHTML;

    public HTMLTraitement() {

        suppHTMLEntities = Boolean.TRUE;
        aplatirHTML = Boolean.TRUE;
    }

    @Override
    public String executer(String entre) {

        // On commence par 

        String retour="";

        Parser parser = Parser.htmlParser();
        
        return Jsoup.parse(entre).text();

//
//        Document doc = Jsoup.parse(entre);
//        doc.outputSettings().charset("UTF-8");
//
////        Document doc = Jsoup.parse(entre);
//        if (aplatirHTML) {
//            doc = new Cleaner(Whitelist.none()).clean(doc);
//            retour = doc.body().text();
//        } else {
//            retour = doc.body().outerHtml();
//        }
//        
//
//        if (suppHTMLEntities) {
//            doc.outputSettings().escapeMode(null);
//            retour= Parser.unescapeEntities(retour, true);
//        }
//        
//
//        return retour;
    }

    public Boolean getSuppHTMLEntities() {
        return suppHTMLEntities;
    }

    public void setSuppHTMLEntities(Boolean suppHTMLEntities) {
        this.suppHTMLEntities = suppHTMLEntities;
    }

    public Boolean getAplatirHTML() {
        return aplatirHTML;
    }

    public void setAplatirHTML(Boolean aplatirHTML) {
        this.aplatirHTML = aplatirHTML;
    }
    
    

    public static void main(String[] args) {
        HTMLTraitement hTMLTraitement = new HTMLTraitement();
        hTMLTraitement.aplatirHTML = true;
        hTMLTraitement.suppHTMLEntities = true;

        String resu = hTMLTraitement.executer("&lt;&copy;Le turc a lÃ¢chÃ© du lest samedi, en rouvrant aux manifestants qui dÃ©noncent sa politique l'accÃ¨s Ã  la place Taksim Ã  Istanbul, le cÅ“ur de la rÃ©volte.<img width=\\\"1\\\" height=\\\"1\\\" src=\\\"http://rss.lemonde.fr/c/205/f/3052/s/2cb87eef/mf.gif\\\" border=\\\"0\\\" /><br/><br/><a href=\\\"http://da.feedsportal.com/r/165664750768/u/197/f/3052/c/205/s/2cb87eef/a2.htm\\\"><img src=\\\"http://da.feedsportal.com/r/165664750768/u/197/f/3052/c/205/s/2cb87eef/a2.img\\\" border=\\\"0\\\" /></a><img width=\\\"1\\\" height=\\\"1\\\" src=\\\"http://pi.feedsportal.com/r/165664750768/u/197/f/3052/c/205/s/2cb87eef/a2t.img\\\" border=\\\"0\\\" />");
        System.out.println(resu);

    }
}
