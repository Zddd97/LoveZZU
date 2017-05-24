package com.gjf.lovezzu.entity;

import java.io.Serializable;

/**
 * Created by zhaox on 2017/5/24.
 */

public class JobItem implements Serializable{
    private int jobType;
    private String jobTitle;
    private String jobContent;
    private String jobTime;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }
    public JobItem(){
        super();
    }
    public JobItem (int jobType,String jobTitle,String jobContent,String jobTime){
        this.jobType=jobType;
        this.jobTitle=jobTitle;
        this.jobContent=jobContent;
        this.jobTime=jobTime;
    }
}
