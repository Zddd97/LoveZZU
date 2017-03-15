package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.UserInfoResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/10.
 */
public interface GetUserInfoServer {
    @FormUrlEncoded
    @POST("queryuserinfoAction")
    Observable<UserInfoResult> getInfo(@Field("identifier") String identifier,@Field("phone") String phone, @Field("password") String password);
}
