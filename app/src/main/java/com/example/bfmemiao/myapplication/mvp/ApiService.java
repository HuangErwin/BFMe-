package com.example.bfmemiao.myapplication.mvp;

import com.example.bfmemiao.myapplication.bean.BaseBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public interface ApiService {

    //登录
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("Index/HomeData")
    Observable<BaseBean> requestHomeDate(@Body RequestBody body);

    //登录
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("Category/GetHomeCategories")
    Observable<BaseBean> requestCategory();

    //登录
    @FormUrlEncoded
    @POST("UGCTopic/SearchUGCTopicsList")
    Observable<BaseBean> requestTalk(@Field("pageSize") String first, @Field("pageNo") String last);
}
