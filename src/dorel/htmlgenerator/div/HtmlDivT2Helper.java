package dorel.htmlgenerator.div;

import dorel.htmlgenerator.HtmlElementHelper;
import dorel.htmlgenerator.HtmlElementInterface;
import dorel.htmlgenerator.StyleRule;
import dorel.htmlgenerator.StyleSheet;
import dorel.htmlgenerator.table.HtmlTableColumn;
import dorel.htmlgenerator.table.HtmlTableRowInterface;
import java.util.List;

public class HtmlDivT2Helper {

    private List<HtmlTableColumn> columns;
    private HtmlTableRowInterface tableRow;

    public void addColumn(HtmlTableColumn col) {
        columns.add(col);
    }

    public void setRow(HtmlTableRowInterface tri) {
        tableRow = tri;
    }

    public void setColumns(List<HtmlTableColumn> columns) {
        this.columns = columns;
    }

    public HtmlDivT2Helper(List<HtmlTableColumn> columns, HtmlTableRowInterface row) {
        this.columns = columns;
        this.tableRow = row;
    }

    public static void addCss(StyleSheet style) {
        StyleRule sc;
        sc = new StyleRule(".divTable");
        sc.addProp("display", "table");
        sc.addProp("width", "auto");
        style.addStyleRule(sc);

        sc = new StyleRule(".divRow");
        sc.addProp("display", "table-row");
        sc.addProp("width", "auto");
        style.addStyleRule(sc);

        sc = new StyleRule(".divCellTitle");
        sc.addProp("display", "table-column");
        sc.addProp("float", "left");
        sc.addProp("width", "200px");
        style.addStyleRule(sc);

        sc = new StyleRule(".divCellValue");
        sc.addProp("display", "table-column");
        sc.addProp("float", "left");
        sc.addProp("width", "440px");
        sc.addProp("font-weight", "bold");
        style.addStyleRule(sc);
    }

    public HtmlElementInterface getElement() {
        HtmlElementInterface row;
        HtmlElementInterface cell;
        HtmlElementInterface table = new HtmlElementHelper("div");
        table.addAtribute("class", "divTable");
        //

        for (HtmlTableColumn tc : columns) {
            row = new HtmlElementHelper("div");
            row.addAtribute("class", "divRow");

            cell = new HtmlElementHelper("div", tc.getTitle() + ": ");
            cell.addAtribute("class", "divCellTitle");
            row.addHtmlElement(cell);

            String value = tableRow.getValueByName(tc.getTitle());
            if (value.isEmpty()) {
                value = "&nbsp;";
            }
            cell = new HtmlElementHelper("div", value);
            cell.addAtribute("class", "divCellValue");
            row.addHtmlElement(cell);

            table.addHtmlElement(row);
        }
        return table;
    }
}
