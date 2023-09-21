package org.deltixuat.elements;

public enum SummaryPageElements {
    SUMMARY("Summary dashboard"),
    GRID("Grid & chart"),
    HISTOGRAM("Histogram"),
    SCATTER_PLOT("Scatter-plot"),
    REPORTS("Reports");



    private String value;
    SummaryPageElements(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
