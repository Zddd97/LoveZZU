package com.gjf.lovezzu.entity;

/**
 * Created by BlackBeard丶 on 2017/04/08.
 */

public class SchoolNewsSubjectResult {
    private String News_Id;
    private String News_Title;
    private String Author;
    private String Subject;
    private String Time;
    private String ReadNumber;
    private String LikesNumber;
    private String CommentNumber;

    public String getNews_Title() {
        return News_Title;
    }

    public void setNews_Title(String news_Title) {
        News_Title = news_Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getReadNumber() {
        return ReadNumber;
    }

    public void setReadNumber(String readNumber) {
        ReadNumber = readNumber;
    }

    public String getLikesNumber() {
        return LikesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        LikesNumber = likesNumber;
    }

    public String getCommentNumber() {
        return CommentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        CommentNumber = commentNumber;
    }

    public String getNews_Id() {
        return News_Id;
    }

    public void setNews_Id(String news_Id) {
        News_Id = news_Id;
    }
}
