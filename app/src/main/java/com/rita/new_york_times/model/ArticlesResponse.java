package com.rita.new_york_times.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticlesResponse {
    @SerializedName("results")
    private List<ArticleJSON> results;

    public ArticlesResponse() {}

    public ArticlesResponse(List<ArticleJSON> results) {
        this.results = results;
    }

    public List<ArticleJSON> getResults() {
        return results;
    }

    public void setResults(List<ArticleJSON> results) {
        this.results = results;
    }
}
