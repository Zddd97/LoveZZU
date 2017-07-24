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
 * Created by BlackBeard丶 on 2017/6/30.
 */

public interface SchoolJobServer {

    @GET("advisory.action")
    Observable<TreeHoleData> getHomePageList(@Query("page") int pageNO);


    @FormUrlEncoded
    @POST("发送")
    Observable<TreeHoleData> sendTUCAOContent(Subscriber<TreeHoleData> subscriber, @Field("SessionID") String SessionID, @Field("content") String Content);

    @FormUrlEncoded
    @POST("获得某条内容")
    Observable<TreeHoleData> getTreeHoleContent(Subscriber<TreeHoleData> subscriber, @Field("newsid") String newsid);


    @FormUrlEncoded
    @POST("获得评论")
    Observable<TreeHoleData> getComment(Subscriber<TreeHoleData> subscriber, @Field("id") String newsid);

    @FormUrlEncoded
    @POST("发送评论")
    Observable<TreeHoleData> sendComment(Subscriber<TreeHoleData> subscriber, @Field("newsid") String newsid , @Field("content") String content, @Field("userid") String userid);

    @FormUrlEncoded
    @POST("点赞")
    Observable<TreeHoleData> LikesNews(Subscriber<TreeHoleData> subscriber, @Field("newsid") String newsid, @Field("userid") String userid);

    @FormUrlEncoded
    @POST("点赞评论")
    Observable<TreeHoleData> LikesComments(Subscriber<TreeHoleData> subscriber, @Field("newsid") String newsid, @Field("userid") String userid, @Field("commentid") String commentid);

}
