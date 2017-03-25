package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.SchoolNewsData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/23.
 */
public interface SchoolNewServer {
    @GET("福利/100/{pageNO}")
    Observable<SchoolNewsData> getNews(@Path("pageNO")int pageNO);
}
