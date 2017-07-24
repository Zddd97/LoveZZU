package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.SchoolTopAndMidNewsResult;
import com.gjf.lovezzu.network.api.GetSchoolTopNewsServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlackBeard丶 on 2017/04/09.
 */

public class GetSchoolTopNewsMethods {
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;

    private GetSchoolTopNewsServer getSchoolTopNewsServer;

    private GetSchoolTopNewsMethods(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.News_Url)
                .build();

        getSchoolTopNewsServer = retrofit.create(GetSchoolTopNewsServer.class);

    }


    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final GetSchoolTopNewsMethods INSTANCE = new GetSchoolTopNewsMethods();
    }

    private static GetSchoolTopNewsMethods getInstance() {
        return GetSchoolTopNewsMethods.SingletonHolder.INSTANCE;
    }

    public void getSchoolNews(Subscriber<SchoolTopAndMidNewsResult> subscriber, int page) {
        getSchoolTopNewsServer.getSchoolTopNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
