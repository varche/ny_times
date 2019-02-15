package com.rita.new_york_times.model;

public interface Article {

    public long getId();

    public String getTitle();

    public String getPublished_date();

    public String getArticle_abstract();

    public void setId(long id);

    public void setTitle(String title);

    public void setPublished_date(String published_date);

    public void setArticle_abstract(String article_abstract);
}
