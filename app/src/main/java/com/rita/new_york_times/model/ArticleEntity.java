package com.rita.new_york_times.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity implements Article {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "published_date")
    private String published_date;

    @ColumnInfo(name = "abstract")
    private String article_abstract;

    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;


    public ArticleEntity(long id, String title, String published_date, String article_abstract, byte[] image) {
        this.id = id;
        this.title = title;
        this.published_date = published_date;
        this.article_abstract = article_abstract;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public String getArticle_abstract() {
        return article_abstract;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public void setArticle_abstract(String article_abstract) {
        this.article_abstract = article_abstract;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
