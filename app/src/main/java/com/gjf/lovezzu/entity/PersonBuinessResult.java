package com.gjf.lovezzu.entity;

/**
 * Created by BlackBeard丶 on 2017/04/09.
 */

public class PersonBuinessResult {
    private int price;
    private int totalprice;
    private String goodname;
    private String jianshu;
    private int number;
    private String url;

    public PersonBuinessResult(int price, int totalprice, String goodname, String jianshu, int number, String url) {
        this.price = price;
        this.totalprice = totalprice;
        this.goodname = goodname;
        this.jianshu = jianshu;
        this.number = number;
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getJianshu() {
        return jianshu;
    }

    public void setJianshu(String jianshu) {
        this.jianshu = jianshu;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
