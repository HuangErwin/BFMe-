package com.example.bfmemiao.myapplication.mvp.view;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public interface HomeView {

    void showProcress();

    void parserDate(Object data);

    void hintProcress();

    void errorHandling(Throwable e);
}
