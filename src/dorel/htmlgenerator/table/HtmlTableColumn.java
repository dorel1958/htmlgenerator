package dorel.htmlgenerator.table;

public class HtmlTableColumn {

    private int width;
    private String title;
    private String tabela_ref;
    private String coloana_ref;
    private boolean eReferinta;
    private boolean eLink;
    private String linkul;
    private String numeJava;

    //<editor-fold defaultstate="collapsed" desc="Set Get">
    public String getLinkul() {
        return linkul;
    }

    public void setLinkul(String linkul) {
        this.linkul = linkul;
    }

    public boolean isLink() {
        return eLink;
    }

    public void setLink(boolean eLink) {
        this.eLink = eLink;
    }

    public boolean isReferinta() {
        return eReferinta;
    }

    public void setReferinta(boolean eReferinta) {
        this.eReferinta = eReferinta;
    }

    public String getColoana_ref() {
        return coloana_ref;
    }

    public void setColoana_ref(String coloana_ref) {
        this.coloana_ref = coloana_ref;
    }

    public String getTabela_ref() {
        return tabela_ref;
    }

    public void setTabela_ref(String tabela_ref) {
        this.tabela_ref = tabela_ref;
    }

    public String getTitle() {
        return title;
    }
    public String getNumeJava() {
        return numeJava;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    //</editor-fold>

    public HtmlTableColumn(String title, int width, boolean eReferinta, String tabela_ref, String coloana_ref) {
        this.title = title;
        this.width = width;
        this.eReferinta = eReferinta;
        if (eReferinta) {
            this.tabela_ref = tabela_ref;
            this.coloana_ref = coloana_ref;
        }
        eLink=false;
        linkul="";
        this.numeJava=title;
    }

    public HtmlTableColumn(String title, int width) {
        this.title = title;
        this.width = width;
        this.eReferinta = false;
        this.tabela_ref = "";
        this.coloana_ref = "";
        eLink=false;
        linkul="";
        this.numeJava=title;
    }

    public HtmlTableColumn(String title, int width, boolean eLink, String linkul) {
        this.title = title;
        this.width = width;
        this.eLink = eLink;
        if (eLink) {
            this.linkul = linkul;
        }
        this.eReferinta = false;
        this.tabela_ref = "";
        this.coloana_ref = "";
        this.numeJava=title;
    }

    public HtmlTableColumn(String title, String numeJava, int width) {
        this.title = title;
        this.width = width;
        this.eLink = false;
        this.eReferinta = false;
        this.tabela_ref = "";
        this.coloana_ref = "";
        this.numeJava=numeJava;
    }
}
