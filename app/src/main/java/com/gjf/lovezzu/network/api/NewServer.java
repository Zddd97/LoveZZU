package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.SocietyNewsData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/17.
 */
public interface   NewServer {
    @GET("福利/1000/{pageNO}")
    Observable<SocietyNewsData> getNews(@Path("pageNO")int pageNO);
}
