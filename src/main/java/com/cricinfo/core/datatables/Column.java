/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cricinfo.core.datatables;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author md.anwar
 */
public class Column {

    private String data;
    private String name;
    private String searchable;
    private String orderable;
    private Search search;

    @JsonProperty("data")
    public String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(String value) {
        this.data = value;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String value) {
        this.name = value;
    }

    @JsonProperty("searchable")
    public String getSearchable() {
        return searchable;
    }

    @JsonProperty("searchable")
    public void setSearchable(String value) {
        this.searchable = value;
    }

    @JsonProperty("orderable")
    public String getOrderable() {
        return orderable;
    }

    @JsonProperty("orderable")
    public void setOrderable(String value) {
        this.orderable = value;
    }

    @JsonProperty("search")
    public Search getSearch() {
        return search;
    }

    @JsonProperty("search")
    public void setSearch(Search value) {
        this.search = value;
    }
}
