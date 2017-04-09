package com.gjf.lovezzu.entity;

/**
 * Created by zhaox on 2017/4/9.
 */

public class PlayEnd {
    private int groupImage;
    private String groupName;
    private String groupInfo;
    private int[] groupTagsImages;
    private String groupNewsTitle;
    private int[] infoImages;
    private int[] joinersImages;

    public int getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(int groupImage) {
        this.groupImage = groupImage;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public int[] getGroupTagsImages() {
        return groupTagsImages;
    }

    public void setGroupTagsImages(int[] groupTagsImages) {
        this.groupTagsImages = groupTagsImages;
    }

    public String getGroupNewsTitle() {
        return groupNewsTitle;
    }

    public void setGroupNewsTitle(String groupNewsTitle) {
        this.groupNewsTitle = groupNewsTitle;
    }

    public int[] getInfoImages() {
        return infoImages;
    }

    public void setInfoImages(int[] infoImages) {
        this.infoImages = infoImages;
    }

    public int[] getJoinersImages() {
        return joinersImages;
    }

    public void setJoinersImages(int[] joinersImages) {
        this.joinersImages = joinersImages;
    }
}
