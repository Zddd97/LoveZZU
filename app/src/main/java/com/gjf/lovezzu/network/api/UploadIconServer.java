package com.gjf.lovezzu.network.api;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/10.
 */
public interface UploadIconServer {
    @Multipart
    @POST("upload")
    Observable<ResponseBody> upLoadIcon(@PartMap Map<String, RequestBody> params);
}
