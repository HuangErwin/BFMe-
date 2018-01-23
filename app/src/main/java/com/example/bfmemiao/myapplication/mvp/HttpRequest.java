package com.example.bfmemiao.myapplication.mvp;

import com.example.bfmemiao.myapplication.Constant;
import com.example.bfmemiao.myapplication.bean.BaseBean;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HttpRequest extends RetrofitUtils {


    public static final ApiService service = getRetrofit().create(ApiService.class);
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    private static HttpRequest request;

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    public static HttpRequest getInstance() {
        if (null == request) {
            request = new HttpRequest();
        }
        return request;
    }




    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     */
    private class HttpResultFunc implements Func1 {
        @Override
        public Object call(Object o) {
            return o;
        }
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    private RequestBody createRequestBody(String json) {
        return RequestBody.create(Constant.JSON, json.toString());
    }



    /**
     * 获取图文
     * @param observer
     */
    public void requestHomeDate( Observer<BaseBean> observer) {
        JSONObject json = new JSONObject();
        RequestBody requestBody = createRequestBody(json.toString());
        Observable observable = service.requestHomeDate(requestBody).map(new HttpResultFunc());
        setSubscribe(observable, observer);

    }

    /**
     * 获取图文
     * @param observer
     */
    public void requestCategory( Observer<BaseBean> observer) {
        JSONObject json = new JSONObject();
        RequestBody requestBody = createRequestBody(json.toString());
        Observable observable = service.requestCategory().map(new HttpResultFunc());
        setSubscribe(observable, observer);

    }
}
