package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.TreeHoleData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by BlackBeard丶 on 2017/5/16.
 */

public interface TreeHoleServer {
    @GET("advisory.action")
    Observable<TreeHoleData> getHomePageList(@Query("page") int pageNO);


    @FormUrlEncoded
    @POST("发送")
        Observable<TreeHoleData> sendTUCAOContent(Subscriber<TreeHoleData> subscriber, @Field("SessionID") String SessionID, @Field("content") String Content);
}
