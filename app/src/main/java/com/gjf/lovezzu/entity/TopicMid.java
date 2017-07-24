package com.gjf.lovezzu.entity;

/**
 * Created by zhaox on 2017/3/22.
 */

public class TopicMid {
    private String title;
    private int imageId;
    private String url;
    private String contentUrl;

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public TopicMid(String title, int imageId, String url) {
        this.title = title;
        this.imageId = imageId;
        this.url = url;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
