package tatiana_dworieckaja.deltixuat.enums;

public enum SortOrderEnum {
    ASC("eSortAsc"),
    DESC("eSortDesc"),
    NONE("eSortNone");

    private String order;

    public String getOrder() {
        return order;
    }

    SortOrderEnum(String order) {
        this.order = order;
    }
}
