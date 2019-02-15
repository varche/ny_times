package com.rita.new_york_times.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleJSON implements Article {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("published_date")
    private String published_date;

    @SerializedName("abstract")
    private String article_abstract;

    @SerializedName("media")
    private List<MediaItem> mediaList;


    public String getImageUrl() {
        return mediaList.get(0).getMetadataList().get(0).getUrl();
    }

    public ArticleJSON() {}

    public ArticleJSON(int id, String title, String published_date, String article_abstract) {
        this.id = id;
        this.title = title;
        this.published_date = published_date;
        this.article_abstract = article_abstract;
    }



        public class MediaItem {
            @SerializedName("type")
            String type;

            @SerializedName("media-metadata")
            List<MediaMetadata> metadataList;

            public MediaItem() {}

            public MediaItem(String type, List<MediaMetadata> metadataList) {
                this.type = type;
                this.metadataList = metadataList;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setMetadataList(List<MediaMetadata> metadataList) {
                this.metadataList = metadataList;
            }

            public String getType() {
                return type;
            }

            List<MediaMetadata> getMetadataList() {
                return metadataList;
            }

            public class MediaMetadata {
                @SerializedName("url")
                String url;
                @SerializedName("format")
                String format;

                public MediaMetadata() {}

                public MediaMetadata(String url, String format) {
                    this.url = url;
                    this.format = format;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public String getUrl() {
                    return url;
                }

                public String getFormat() {
                    return format;
                }
            }
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

    public String getArticle_abstract() {
        return article_abstract;
    }

    public void setMediaList(List<MediaItem> mediaList) {
        this.mediaList = mediaList;
    }

    public List<MediaItem> getMediaList() {
        return mediaList;
    }
}
