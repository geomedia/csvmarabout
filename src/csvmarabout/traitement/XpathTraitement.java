/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvmarabout.traitement;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Content;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/**
 * Cette classe permet de chercher dans le texte un element et d'effectuer sur
 * celui ci un traitement pour l'instant la supression.
 *
 * @author clem
 */
public class XpathTraitement extends AbstrAtraitement {

    String xPath;

    @Override
    public String executer(String entre) throws Exception {

//        On commence par cleaner le document avec Jsoup pour cleanner la structure et préparer le travail de dom et Xpath
        Parser jSoupParse = Parser.xmlParser();
        Document docJsoup = jSoupParse.parseInput(entre, "truc");
        String retour = "";

        try {
            // On parse un document DOM2;
            SAXBuilder saxb = new SAXBuilder();
            StringReader reader = new StringReader(docJsoup.outerHtml());
            org.jdom2.Document domDoc = saxb.build(reader);

            // Traitement XPATH
            List<Object> resuXpth = org.jdom2.xpath.XPathFactory.instance().compile(xPath).evaluate(domDoc);

            int i;
            for (i = 0; i < resuXpth.size(); i++) {
                domDoc.getRootElement().removeContent((Content) resuXpth.get(i));
            }

            // On applique le traitement Xpath
            org.jdom2.output.XMLOutputter xmlo = new XMLOutputter();
            retour = xmlo.outputString(domDoc);

        } catch (JDOMException ex) {
            Logger.getLogger(XpathTraitement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XpathTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retour;
    }

    public static void main(String[] args) {

        String test = "<HTML><zaza>coucou</zaza><zozo>pouet</zozo></HTML>";
        XpathTraitement traitement = new XpathTraitement();
        traitement.xPath = "//zozo";
        try {
            test = traitement.executer(test);
        } catch (Exception ex) {
            Logger.getLogger(XpathTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(test);
    }

    public String getxPath() {
        return xPath;
    }

    public void setxPath(String xPath) {
        this.xPath = xPath;
    }
}
