package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.TreeHoleData;
import com.gjf.lovezzu.network.api.TreeHoleServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlackBeard丶 on 2017/6/30.
 */

public class SchoolJobMethods {
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    private TreeHoleServer treeHoleServer;

    private SchoolJobMethods() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.News_Url)
                .build();

        treeHoleServer = retrofit.create(TreeHoleServer.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final SchoolJobMethods INSTANCE = new SchoolJobMethods();
    }

    //获取单例
    public static SchoolJobMethods getInstance() {
        return SchoolJobMethods.SingletonHolder.INSTANCE;
    }


    public void getHomePageList(Subscriber<TreeHoleData> subscriber, int page) {
        treeHoleServer.getHomePageList(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void sendTUCAOContent(Subscriber<TreeHoleData> subscriber, String sessionId ,String content) {
        treeHoleServer.sendTUCAOContent(subscriber,sessionId,content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getTreeHoleContent(Subscriber<TreeHoleData> subscriber, String newsid ) {
        treeHoleServer.getTreeHoleContent(subscriber,newsid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getComment(Subscriber<TreeHoleData> subscriber, String newsid ) {
        treeHoleServer.getComment(subscriber,newsid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void sendComment(Subscriber<TreeHoleData> subscriber, String newsid,String content,String  userid) {
        treeHoleServer.sendComment(subscriber,newsid,content,userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public void LikesNews(Subscriber<TreeHoleData> subscriber, String newsid,String  userid) {
        treeHoleServer.LikesNews(subscriber,newsid,userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void LikesComments(Subscriber<TreeHoleData> subscriber, String newsid,String  userid,String commentsid) {
        treeHoleServer.LikesComments(subscriber,newsid,userid,commentsid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
