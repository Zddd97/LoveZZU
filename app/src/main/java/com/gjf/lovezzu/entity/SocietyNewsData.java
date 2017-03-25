package com.gjf.lovezzu.entity;

import java.util.List;

/**
 * Created by BlackBeard丶 on 2017/03/19.
 */
public class SocietyNewsData {
    private boolean error;
    private List<SocietyNewsResult> results;

    public List<SocietyNewsResult> getResults() {
        return results;
    }

    public void setResults(List<SocietyNewsResult> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }



}
