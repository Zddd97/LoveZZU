package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.UserInfoResult;
import com.gjf.lovezzu.network.api.GetUserInfoServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlackBeard丶 on 2017/03/10.
 */
public class GetUserInfoMethods {
    private Retrofit retrofit;
    private GetUserInfoServer getUserInfoServer;
    private static final int DEFAULT_TIMEOUT = 5;

    private GetUserInfoMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.LOGIN_URL)
                .build();
        getUserInfoServer = retrofit.create(GetUserInfoServer.class);
    }

    private static class SingletonHolder {
        private static final GetUserInfoMethods INSTANCE = new GetUserInfoMethods();
    }

    public static GetUserInfoMethods getUserInfoMethods() {
        return SingletonHolder.INSTANCE;
    }

    public void goToGetUserInfo(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String password) {
        getUserInfoServer.getInfo(identifier, phone, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
