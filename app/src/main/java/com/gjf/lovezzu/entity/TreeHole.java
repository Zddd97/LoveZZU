package com.gjf.lovezzu.entity;

/**
 * Created by zhao on 2017/5/4.
 */

public class TreeHole {
    private String treeContent;
    private String itemTest;
    private String zanNumber;
    private String talkNumber;

    String treeHoleid;
    String praiseNumber;
    String commentNumber;
    String content;

    public String getTreeHoleid() {
        return treeHoleid;
    }

    public void setTreeHoleid(String treeHoleid) {
        this.treeHoleid = treeHoleid;
    }

    public String getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(String praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TreeHole(){

    }


    public TreeHole(String treeContent, String itemTest, String zanNumber, String talkNumber, String treeHoleid, String praiseNumber, String commentNumber, String content) {
        this.treeContent = treeContent;
        this.itemTest = itemTest;
        this.zanNumber = zanNumber;
        this.talkNumber = talkNumber;
        this.treeHoleid = treeHoleid;
        this.praiseNumber = praiseNumber;
        this.commentNumber = commentNumber;
        this.content = content;
    }

    public String getTreeContent() {
        return treeContent;
    }

    public void setTreeContent(String treeContent) {
        this.treeContent = treeContent;
    }

    public String getItemTest() {
        return itemTest;
    }

    public void setItemTest(String itemTest) {
        this.itemTest = itemTest;
    }

    public String getZanNumber() {
        return zanNumber;
    }

    public void setZanNumber(String zanNumber) {
        this.zanNumber = zanNumber;
    }

    public String getTalkNumber() {
        return talkNumber;
    }

    public void setTalkNumber(String talkNumber) {
        this.talkNumber = talkNumber;
    }
}
