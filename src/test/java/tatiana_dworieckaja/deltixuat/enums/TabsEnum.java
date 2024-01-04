package tatiana_dworieckaja.deltixuat.enums;

public enum TabsEnum {
    SUMMARY("Summary dashboard"),
    GRID("Grid & chart"),
    HISTOGRAM("Histogram"),
    SCATTER_PLOT("Scatter-plot"),
    REPORTS("Reports");

    private String value;

    TabsEnum(String value) {
        this.value = value;
    }

    public String getTitle() {
        return value;
    }
}
