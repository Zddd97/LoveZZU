package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.LoginResult;
import com.gjf.lovezzu.network.api.SingupServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlackBeard丶 on 2017/03/05.
 */
public class SingupMethods {
    private Retrofit retrofit;
    private SingupServer singupServer;
    private static final int DEFAULT_TIMEOUT = 5;

    private SingupMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);


        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.LOGIN_URL)
                .build();

        singupServer = retrofit.create(SingupServer.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final SingupMethods INSTANCE = new SingupMethods() {
        };
    }

    //获取单例
    public static SingupMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void goToSingup(Subscriber<LoginResult> subscriber, String identifier, boolean issuccesful, String phone, String password) {
        singupServer.register(identifier, issuccesful, phone, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
