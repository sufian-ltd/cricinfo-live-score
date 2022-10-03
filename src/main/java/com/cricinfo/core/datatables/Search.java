package com.cricinfo.core.datatables;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

    private String value;
    private String regex;

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("regex")
    public String getRegex() {
        return regex;
    }

    @JsonProperty("regex")
    public void setRegex(String value) {
        this.regex = value;
    }
}
