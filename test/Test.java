
import dorel.htmlgenerator.HtmlElementHelper;
import dorel.htmlgenerator.HtmlElementInterface;
import dorel.htmlgenerator.tags.Page;
import dorel.htmlgenerator.tags.HtmlDiv;
import dorel.htmlgenerator.StyleSheet;
import dorel.htmlgenerator.StyleRule;
import dorel.htmlgenerator.tags.XmlDocument;

public class Test {

    public String testeaza() {
        String str;

        HtmlElementInterface head = new HtmlElementHelper("head");
        //head.addHtmlElement(new Link("stylesheet", "text/css", "resources/css/report.css"));
        StyleSheet style = new StyleSheet();
        StyleRule sc;

        sc = new StyleRule("table");
        sc.addProp("border-collapse", "collapse");
        style.addStyleRule(sc);

        sc = new StyleRule("table, td, th");
        sc.addProp("border", "1px solid black");
        style.addStyleRule(sc);

        sc = new StyleRule("th");
        sc.addProp("font-weight", "bold");
        style.addStyleRule(sc);

        head.addHtmlElement(style);

        HtmlElementInterface body = new HtmlElementHelper("body");

        HtmlElementInterface tableTop = new HtmlElementHelper("table");

        HtmlElementInterface row;
        HtmlElementInterface cell;
        row = new HtmlElementHelper("tr");
        cell = new HtmlElementHelper("th", "Judfdg fg f df hdf df df fs sfdh d fdf ");
        cell.addAtribute("width", "50px");
        row.addHtmlElement(cell);
        row.addHtmlElement(new HtmlElementHelper("th", "loc"));
        row.addHtmlElement(new HtmlElementHelper("th", "zzz"));
        tableTop.addHtmlElement(row);

        row = new HtmlElementHelper("tr");
        row.addHtmlElement(new HtmlElementHelper("td", "Judfdg fg f df hdf df df fs sfdh d fdf "));
        row.addHtmlElement(new HtmlElementHelper("td", "loc"));
        row.addHtmlElement(new HtmlElementHelper("td", "zzz"));
        tableTop.addHtmlElement(row);

        body.addHtmlElement(new HtmlDiv("titleFT", "FIŞA TEREN SPAŢIU VERDE"));

        body.addHtmlElement(tableTop);

        HtmlElementInterface pag = new Page(head, body);
        str = pag.getText();
        return str;
    }

    public String testKml() {
        XmlDocument doc = new XmlDocument("kml");
        doc.addAtribute("xmlns", "http://earth.google.com/kml/2.0");

        HtmlElementHelper document = new HtmlElementHelper("Document");
        HtmlElementHelper name = new HtmlElementHelper("name", "KML document");
        document.addHtmlElement(name);
        HtmlElementHelper open = new HtmlElementHelper("open", "1");
        document.addHtmlElement(open);
        HtmlElementHelper description = new HtmlElementHelper("description", "Elementele grafice ale hărții");
        document.addHtmlElement(description);

        // style
        HtmlElementHelper style1 = new HtmlElementHelper("Style");
        style1.addAtribute("id", "noDrivingDirections");
        HtmlElementHelper bs1 = new HtmlElementHelper("BaloonStyle");
        HtmlElementHelper text1 = new HtmlElementHelper("text","<![CDATA[<b>$[name]</b><br /><br />$[description]]]>");
        bs1.addHtmlElement(text1);
        style1.addHtmlElement(bs1);
        document.addHtmlElement(style1);
        
        //Folder
        HtmlElementHelper folder = new HtmlElementHelper("Folder");
        HtmlElementHelper fname = new HtmlElementHelper("name", "Paths");
        folder.addHtmlElement(fname);
        HtmlElementHelper fvizibility = new HtmlElementHelper("visibility", "0");
        folder.addHtmlElement(fvizibility);
        HtmlElementHelper fdescription = new HtmlElementHelper("description", "Examples of paths. Note that the tessellate tag is by default set to 0. If you want to create tessellated lines, they must be authored (or edited) directly in KML.");
        folder.addHtmlElement(fdescription);
        
        // folder.AddPlacemark-uri
        HtmlElementHelper pm1 = new HtmlElementHelper("Placemark");
        HtmlElementHelper mp1_name = new HtmlElementHelper("name", "Poligon");
        pm1.addHtmlElement(mp1_name);
        HtmlElementHelper mp1_description = new HtmlElementHelper("description", "descriere");
        pm1.addHtmlElement(mp1_description);
        HtmlElementHelper mp1_poligon = new HtmlElementHelper("Polygon");
        HtmlElementHelper mp1_ob = new HtmlElementHelper("outerBoundaryIs");
        HtmlElementHelper mp1_lr = new HtmlElementHelper("LinearRing");
        HtmlElementHelper mp1_coord = new HtmlElementHelper("coordinates", "24.355110595463, 45.103299908792 24.355442511389, 45.103148739162 24.355049798981, 45.102982781199 24.354729385093, 45.103258830088 24.355110595463, 45.103299908792");
        mp1_lr.addHtmlElement(mp1_coord);
        mp1_ob.addHtmlElement(mp1_lr);
        mp1_poligon.addHtmlElement(mp1_ob);
        pm1.addHtmlElement(mp1_poligon);
        
        folder.addHtmlElement(pm1);

        
        document.addHtmlElement(folder);

        doc.addHtmlElement(document);
        return doc.getText();
    }
}
