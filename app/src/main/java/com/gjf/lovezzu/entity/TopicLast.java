package com.gjf.lovezzu.entity;

/**
 * Created by zhaox on 2017/3/22.
 */

public class TopicLast {
    private String title;
    private String content;
    private String start;
    private String talk;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TopicLast() {
    }

    //测试
    public TopicLast(String title, String content, String start, String talk) {
        this.title = title;
        this.content = content;
        this.start = start;
        this.talk = talk;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
