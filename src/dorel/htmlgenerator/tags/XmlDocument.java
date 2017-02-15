package dorel.htmlgenerator.tags;

import dorel.htmlgenerator.HtmlElementHelper;

public class XmlDocument extends HtmlElementHelper{
    public XmlDocument(String mainTag){
        super(mainTag);
        isXmlDocument=true;
    }
}
