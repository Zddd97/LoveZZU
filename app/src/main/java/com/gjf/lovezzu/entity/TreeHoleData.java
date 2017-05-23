package com.gjf.lovezzu.entity;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/5/23.
 */

public class TreeHoleData {
    private List<TreeHoleResult> results;
    private String code;

    public List<TreeHoleResult> getResults() {
        return results;
    }

    public void setResults(List<TreeHoleResult> results) {
        this.results = results;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
