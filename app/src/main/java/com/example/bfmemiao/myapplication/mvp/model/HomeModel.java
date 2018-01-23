package com.example.bfmemiao.myapplication.mvp.model;

import android.widget.Toast;

import com.example.bfmemiao.myapplication.BaseApplication;
import com.example.bfmemiao.myapplication.bean.BaseBean;
import com.example.bfmemiao.myapplication.bean.CategoryAllBean;
import com.example.bfmemiao.myapplication.bean.HomeBean;
import com.example.bfmemiao.myapplication.listener.OnLoadDataListener;
import com.example.bfmemiao.myapplication.mvp.HttpRequest;
import com.google.gson.Gson;

import rx.Observer;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomeModel {
    public void requestHomeDate(final OnLoadDataListener listener) {
        HttpRequest.getInstance().requestHomeDate(new Observer<BaseBean>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onNext(BaseBean result) {
               if(result.getErrCode().equals("0")){
                   HomeBean homeBean = new Gson().fromJson(result.getData(), HomeBean.class);
                   listener.onSuccess(homeBean);
//                   Toast.makeText(BaseApplication.getApplication(), "走到这里了！", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }  public void requestCategory(final OnLoadDataListener listener) {
        HttpRequest.getInstance().requestCategory(new Observer<BaseBean>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);
            }

            @Override
            public void onNext(BaseBean result) {
               if(result.getErrCode().equals("0")){
                   CategoryAllBean homeBean = new Gson().fromJson(result.getData(), CategoryAllBean.class);
                   listener.onSuccess(homeBean);
                   Toast.makeText(BaseApplication.getApplication(), "走到这里了！", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}
