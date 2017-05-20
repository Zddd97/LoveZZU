package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.TreeHole;
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
 * Created by BlackBeard丶 on 2017/5/16.
 */

public class TreeHoleMethods {
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

 private TreeHoleServer treeHoleServer;

    private TreeHoleMethods() {
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
        private static final TreeHoleMethods INSTANCE = new TreeHoleMethods();
    }

    //获取单例
    public static TreeHoleMethods getInstance() {
        return TreeHoleMethods.SingletonHolder.INSTANCE;
    }


    public void getHomePageList(Subscriber<TreeHole> subscriber, int page) {
        treeHoleServer.getHomePageList(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
