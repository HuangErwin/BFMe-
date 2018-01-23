package com.example.bfmemiao.myapplication.listener;

/**
 * Created by huangjunhui on 2017/2/21.13:31
 */
public interface OnLoadDataListener<T> {
    void onSuccess(T data);
    void onFailure(Throwable e);
}
