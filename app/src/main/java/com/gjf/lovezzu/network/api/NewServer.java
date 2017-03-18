package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.NewsResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/17.
 */
public interface   NewServer {
    @GET("top250")
    Observable<NewsResult> getNews(@Query("start")int start,@Query("count")int count);
}
