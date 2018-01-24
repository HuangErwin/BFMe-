package com.example.bfmemiao.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bfmemiao.myapplication.BaseActivity;
import com.example.bfmemiao.myapplication.R;
import com.example.bfmemiao.myapplication.bean.TalkBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class TalkRecycleViewAdapter extends BaseRecycleViewAdapter {
    private  List<TalkBean.TopicsListBean> topicsList;
    private  BaseActivity mActivity;
    private View footView;

    public TalkRecycleViewAdapter(BaseActivity mActivity, List<TalkBean.TopicsListBean> topicsList) {
        this.mActivity = mActivity;
        this.topicsList = topicsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case ITEM_TYPE_CONTENT:
                View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_talk_content,null);
                return new TalkRecycleViewHoler(view);
            case ITEM_TYPE_FOOT:
                footView = LayoutInflater.from(mActivity).inflate(R.layout.application_footview,null);
                hintFootView();
                return new TalkFootRecycleViewHolder(footView);
        }

        return null;

    }

    public void showFootView(){
        if(footView!=null){
            footView.setVisibility(View.VISIBLE);
        }
    }

    public void  hintFootView(){
        if(footView!=null){
            footView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof TalkRecycleViewHoler){
             TalkRecycleViewHoler holder1 = (TalkRecycleViewHoler) holder;
             holder1.mTvTitle.setText(topicsList.get(position).getContent());
             Glide.with(mActivity).load(topicsList.get(position).getImageUrl())
                        .error(R.mipmap.zhanwei4)
                        .placeholder(R.mipmap.zhanwei4)
                         .into(holder1.mIvImage);

         }
    }



    @Override
    public int getItemCount() {
        return topicsList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {

        if(position == getItemCount()-1){
            return ITEM_TYPE_FOOT;
        }

        return ITEM_TYPE_CONTENT;
    }

    private class TalkRecycleViewHoler extends RecyclerView.ViewHolder {

        private  ImageView mIvImage;
        private  TextView mTvTitle;

        public TalkRecycleViewHoler(View view) {
            super(view);
            mIvImage = (ImageView) view.findViewById(R.id.image);
            mTvTitle = (TextView) view.findViewById(R.id.textview);
        }
    }

    private class TalkFootRecycleViewHolder extends RecyclerView.ViewHolder {
        public TalkFootRecycleViewHolder(View footView) {
            super(footView);
            AutoUtils.auto(footView);

        }
    }
}
