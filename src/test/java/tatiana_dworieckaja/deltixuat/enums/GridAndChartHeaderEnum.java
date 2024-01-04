package tatiana_dworieckaja.deltixuat.enums;

public enum GridAndChartHeaderEnum {
    ID("orderId"),
    TYPE("orderType"),
    INSTRUMENT("orderInstrument"),
    SIDE("orderSide"),
    END_TIME("endTime");

    private String columnId;

    public String getColumnId() {
        return getColumnId();
    }


    GridAndChartHeaderEnum(String columnId) {
        this.columnId = getColumnId();
    }
}
