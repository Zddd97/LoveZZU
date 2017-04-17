package com.gjf.lovezzu.network;

import com.gjf.lovezzu.constant.Url;
import com.gjf.lovezzu.entity.UserInfoResult;
import com.gjf.lovezzu.network.api.EdituserInfoServer;

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
public class SaveUserInfoMethods {
    private Retrofit retrofit;
    private EdituserInfoServer edituserInfoServer;
    private static final int DEFAULT_TIMEOUT = 5;

    private SaveUserInfoMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.LOGIN_URL)
                .build();
        edituserInfoServer = retrofit.create(EdituserInfoServer.class);
    }

    private static class SingletonHolder {
        private static final SaveUserInfoMethods INSTANCE = new SaveUserInfoMethods();
    }

    public static SaveUserInfoMethods saveUserInfoMethods() {
        return SingletonHolder.INSTANCE;
    }

    public void editNickname(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String nicnaem) {
        edituserInfoServer.editNickname(identifier, phone, nicnaem).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void editSex(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String sex) {
        edituserInfoServer.editSex(identifier, phone, sex).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void editHome(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String home) {
        edituserInfoServer.editHome(identifier, phone, home).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void editSchool(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String school) {
        edituserInfoServer.editSchool(identifier, phone, school).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void editClass(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String Class) {
        edituserInfoServer.editClass(identifier, phone, Class).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void editMajor(Subscriber<UserInfoResult> subscriber, String identifier, String phone, String major) {
        edituserInfoServer.editMajor(identifier, phone, major).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
