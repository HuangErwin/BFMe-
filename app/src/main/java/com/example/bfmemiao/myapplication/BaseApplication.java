package com.example.bfmemiao.myapplication;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class BaseApplication extends Application {
    private static BaseApplication mContext = null;


    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext =this;
        //配置AutoLayout
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

    //对外暴露全部变量
    public static BaseApplication getApplication() {
        return mContext;
    }
}
