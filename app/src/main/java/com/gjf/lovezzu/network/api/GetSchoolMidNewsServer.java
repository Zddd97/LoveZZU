package com.gjf.lovezzu.network.api;

import com.gjf.lovezzu.entity.SchoolTopAndMidNewsResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by BlackBeard丶 on 2017/04/09.
 */

public interface GetSchoolMidNewsServer {
    @GET("advisory.action?page={pageNO}")
    Observable<SchoolTopAndMidNewsResult> getSchoolMidNews();
}
