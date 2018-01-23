package com.example.bfmemiao.myapplication;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.inputmethod.InputMethodManager;

import com.example.bfmemiao.myapplication.view.CustomDialog;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by huangjunhui on 2017/10/9.11:14
 */
public abstract class BaseActivity extends AutoLayoutActivity {


    private CustomDialog dialog;
    public BaseActivity mActivity;
    private InputMethodManager inputMethodManager;

    public void showLoadingDialog() {
        if (dialog == null) {
            dialog = new CustomDialog(this);
        }
        dialog.show();

    }

    public void dismissLoadingDialog() {
        if (dialog != null ) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.mActivity = this;
        setupView();
        addListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected abstract void setupView() ;

    protected abstract void addListener() ;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
