package dorel.htmlgenerator.table;

public class HtmlTableRowExample implements HtmlTableRowInterface {

    private String zzz;

    @Override
    public String getValueByName(String colName) {
        String value = "";
        switch (colName) {
            case "zzz":
                value = zzz;
                break;
            default:
                return "coloana inexistenta:" + colName;
        }
        return value;
    }
}
