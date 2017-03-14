package com.gjf.lovezzu.entity;

/**
 * Created by zhao on 2017/3/12.
 */

public class SchoolLast {

    private int imageId;
    private String titletText;
    private String httpUrl;

    public SchoolLast(int imageId, String titletText, String httpUrl) {
        this.imageId = imageId;
        this.titletText = titletText;
        this.httpUrl = httpUrl;

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitletText() {
        return titletText;
    }

    public void settTtletText(String titletText) {
        this.titletText = titletText;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }
}
