package com.gjf.lovezzu.network.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/09.
 */
public interface DownloadIconServer {
    @GET("2017/02/Screenshot_20170219-172019.png")
    Observable<ResponseBody> downloadIconFromNet();
}
