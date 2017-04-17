package com.gjf.lovezzu.entity;

/**
 * Created by zhao on 2017/3/15.
 */

public class SchoolSociety {

    private String httpUrl;

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    private String newsTitle;
    private String newsDate;
    private String newsRead;
    private int newsImage;

    public SchoolSociety(String newsTitle, String newsDate, String newsRead, int newsImage, String httpUrl) {
        this.newsImage = newsImage;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsRead = newsRead;
        this.httpUrl = httpUrl;

    }


    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsRead() {
        return newsRead;
    }

    public void setNewsRead(String newsRead) {
        this.newsRead = newsRead;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }


}
