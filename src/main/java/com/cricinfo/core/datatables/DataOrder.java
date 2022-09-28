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
