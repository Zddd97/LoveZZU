package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.network.api.UploadIconServer;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlackBeard丶 on 2017/03/15.
 */
public class UpLoadIconMethods {
    private Retrofit retrofit;
    private UploadIconServer uploadIconServer;
    private static final int DEFAULT_TIMEOUT = 5;

    private UpLoadIconMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.LOGIN_URL)
                .build();

        uploadIconServer = retrofit.create(UploadIconServer.class);
    }

private static class SingletonHolder {
    private static final UpLoadIconMethods INSTANCE = new UpLoadIconMethods();
}

    public static UpLoadIconMethods upLoadIconMethods() {
        return SingletonHolder.INSTANCE;
    }

    public void goToUploadIcon(Subscriber<ResponseBody> subscriber, Map<String, RequestBody> params) {
        uploadIconServer.upLoadIcon(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
