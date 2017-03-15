package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.UserInfoResult;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/03/10.
 */
public interface UploadIconServer {
    @Multipart
    @FormUrlEncoded
    @POST("")
    Observable<UserInfoResult> upLoadIcon(@Part Map<String, RequestBody> photo,@Field("phone") String phone);
}
