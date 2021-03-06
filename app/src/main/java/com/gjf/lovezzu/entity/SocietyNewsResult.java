package com.gjf.lovezzu.entity;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/03/17.
 */
public class SocietyNewsResult {

    private String _id;

    private String createdAt;

    private List<String> images;

    private String desc;

    private String publishedAt;

    private String source;

    private String type;

    private String url;

    private boolean used;

    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    private SchoolNewsResult schoolNewsResult;

    public SchoolNewsResult getSchoolNewsResult() {
        return schoolNewsResult;
    }

    public void setSchoolNewsResult(SchoolNewsResult schoolNewsResult) {
        this.schoolNewsResult = schoolNewsResult;
    }

    @Override
    public String toString() {
        return "SocietyNewsResult{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", images=" + images +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}

