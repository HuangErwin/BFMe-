package com.example.bfmemiao.myapplication.mvp.model;

import com.example.bfmemiao.myapplication.bean.BaseBean;
import com.example.bfmemiao.myapplication.bean.CategoryAllBean;
import com.example.bfmemiao.myapplication.bean.HomeBean;
import com.example.bfmemiao.myapplication.bean.TalkBean;
import com.example.bfmemiao.myapplication.listener.OnLoadDataListener;
import com.example.bfmemiao.myapplication.mvp.HttpRequest;
import com.google.gson.Gson;

import rx.Observer;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomeModel {
    public void requestTalk(String pageSize, String pageNo,final OnLoadDataListener listener) {
        HttpRequest.getInstance().requestTalk(pageSize,pageNo,new Observer<BaseBean>() {

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
                   TalkBean homeBean = new Gson().fromJson(result.getData(), TalkBean.class);
                   listener.onSuccess(homeBean);
               }
            }
        });
    }

    public void requestGet(final String path, final OnLoadDataListener listener) {
        HttpRequest.getInstance().requestGet(path,new Observer<BaseBean>() {

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
                    switch (path){
                        case "1":
                            CategoryAllBean  categoryAllBean = new Gson().fromJson(result.getData(), CategoryAllBean.class);
                            listener.onSuccess(categoryAllBean);
                            break;
                    }
                }
            }
        });
    }

    public void requestPost(final String path, final OnLoadDataListener listener) {
        HttpRequest.getInstance().requestPost(path,new Observer<BaseBean>() {

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
                    switch (path){
                        case "1":
                            HomeBean homeBean = new Gson().fromJson(result.getData(), HomeBean.class);
                            listener.onSuccess(homeBean);
                            break;
                    }
                }
            }
        });
    }
}
