package com.cricinfo.core.datatables;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataOrder {

    private int column;
    private String dir;

    @JsonProperty("column")
    public int getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(int value) {
        this.column = value;
    }

    @JsonProperty("dir")
    public String getDir() {
        return dir;
    }

    @JsonProperty("dir")
    public void setDir(String value) {
        this.dir = value;
    }
}
