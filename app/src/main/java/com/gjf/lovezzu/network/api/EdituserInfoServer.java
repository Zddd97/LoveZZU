package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.UserInfoResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/10.
 */
public interface EdituserInfoServer {
    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editNickname(@Field("identifier") String identifier,@Field("phone") String phone,@Field("nickname") String nickname);

    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editSex(@Field("identifier") String identifier,@Field("phone") String phone,@Field("gender") String sex);

    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editHome(@Field("identifier") String identifier,@Field("phone") String phone,@Field("hometown") String home);


    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editSchool(@Field("identifier") String identifier,@Field("phone") String phone,@Field("academy") String school);

    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editClass(@Field("identifier") String identifier,@Field("phone") String phone,@Field("departments") String Class);


    @FormUrlEncoded
    @POST("controller")
    Observable<UserInfoResult> editMajor(@Field("identifier") String identifier,@Field("phone") String phone,@Field("professional") String major);

}
