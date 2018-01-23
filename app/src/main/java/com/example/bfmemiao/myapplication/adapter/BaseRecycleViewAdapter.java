package com.example.bfmemiao.myapplication.adapter;

import android.support.v7.widget.RecyclerView;

import com.example.bfmemiao.myapplication.listener.OnHeadViewCoustomClickListener;
import com.example.bfmemiao.myapplication.listener.OnItemCoustomClickListener;


/**
 * Created by huangjunhui on 2017/2/10.12:48
 */
public abstract class BaseRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected OnHeadViewCoustomClickListener mHeadClickListener;

    //item类型
    public static final int ITEM_TYPE_HEADER = 1;
    protected static final int ITEM_TYPE_CONTENT = 2;
    public static final int ITEM_TYPE_FOOT = 3;
    public static final int ITEM_TYPE_EMPTY = 10;



    protected OnItemCoustomClickListener mItemClickListener;



    public void setOnItemClickListener(OnItemCoustomClickListener listener) {
        this.mItemClickListener = listener;
    }
    public void setOnHeadClickListener(OnHeadViewCoustomClickListener listener) {
        this.mHeadClickListener = listener;
    }


}
