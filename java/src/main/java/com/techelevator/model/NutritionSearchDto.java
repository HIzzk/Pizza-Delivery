package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritionSearchDto {

    @JsonProperty("query")
    private String query;
    private String timezone = "US/Eastern";


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    //Parameters: method=foods.search&search_expression=toast&format=json
    public String toString() {
        return "{" +
                    "'query'=" + this.query + "\'," +
                    "'timezone'=" + "'US/Eastern'" + "\'," +
                "}";

    }
}
