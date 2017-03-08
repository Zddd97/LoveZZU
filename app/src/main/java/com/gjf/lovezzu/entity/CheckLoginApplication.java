package com.gjf.lovezzu.entity;

import android.app.Application;

/**
 * Created by BlackBeard丶 on 2017/03/08.
 */
public class CheckLoginApplication extends Application {
    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public void onCreate() {
       isLogin = false;

        super.onCreate();
    }
}
