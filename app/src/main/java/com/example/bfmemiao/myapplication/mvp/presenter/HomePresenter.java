package com.example.bfmemiao.myapplication.mvp.presenter;

import com.example.bfmemiao.myapplication.listener.OnLoadDataListener;
import com.example.bfmemiao.myapplication.mvp.model.HomeModel;
import com.example.bfmemiao.myapplication.mvp.view.HomeView;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomePresenter implements OnLoadDataListener {

    private HomeView homeView;
    private HomeModel homeModel;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();

    }

    @Override
    public void onSuccess(Object data) {
        homeView.parserDate(data);
        homeView.hintProcress();
    }

    @Override
    public void onFailure(Throwable e) {
        homeView.hintProcress();
        homeView.errorHandling(e);
    }

    public void requestHomeDate() {
        homeView.showProcress();
        homeModel.requestHomeDate(this);
    }

    public void requestCategory() {
        homeView.showProcress();
        homeModel.requestCategory(this);
    }
}
