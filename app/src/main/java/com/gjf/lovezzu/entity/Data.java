package com.gjf.lovezzu.entity;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/03/19.
 */
public class Data {
    private boolean error;
    private List<NewsResult> results;

    public List<NewsResult> getResults() {
        return results;
    }

    public void setResults(List<NewsResult> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }



}
