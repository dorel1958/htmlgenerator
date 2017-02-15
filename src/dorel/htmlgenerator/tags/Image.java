package dorel.htmlgenerator.tags;

import dorel.htmlgenerator.HtmlElementHelper;

public class Image extends HtmlElementHelper {

    public Image(String src) {
        super("img");
        addAtribute("src", src);
    }
    
}
