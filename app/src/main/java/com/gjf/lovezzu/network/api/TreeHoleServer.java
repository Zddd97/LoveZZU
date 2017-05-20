package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.TreeHole;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/5/16.
 */

public interface TreeHoleServer {
    @GET("advisory.action")
    Observable<TreeHole> getHomePageList(@Query("page") int pageNO);

}
