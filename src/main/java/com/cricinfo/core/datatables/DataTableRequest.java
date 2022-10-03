package com.cricinfo.core.datatables;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataTableRequest {

    private String draw;
    private List<Column> columns;
    private List<DataOrder> order;
    private int start;
    private int length;
    private Search search;
    private String empty;

    @JsonProperty("draw")
    public String getDraw() {
        return draw;
    }

    @JsonProperty("draw")
    public void setDraw(String value) {
        this.draw = value;
    }

    @JsonProperty("columns")
    public List<Column> getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<Column> value) {
        this.columns = value;
    }

    @JsonProperty("order")
    public List<DataOrder> getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(List<DataOrder> value) {
        this.order = value;
    }

    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(int value) {
        this.start = value;
    }

    @JsonProperty("length")
    public int getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(int value) {
        this.length = value;
    }

    @JsonProperty("search")
    public Search getSearch() {
        return search;
    }

    @JsonProperty("search")
    public void setSearch(Search value) {
        this.search = value;
    }

    @JsonProperty("_")
    public String getEmpty() {
        return empty;
    }

    @JsonProperty("_")
    public void setEmpty(String value) {
        this.empty = value;
    }

}
