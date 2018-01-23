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
import com.example.bfmemiao.myapplication.bean.HomeBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomeRecycleViewAdapter extends BaseRecycleViewAdapter {
    private final BaseActivity mActivity;
    private final List<HomeBean.HomeDataBean.CategoryBean> category;
    private List<HomeBean.HomeDataBean.BottonBannerBean> bottomBanner;
    private List<HomeBean.HomeDataBean.TopBannerBean> topBanner;

    public HomeRecycleViewAdapter(BaseActivity mActivity, List<HomeBean.HomeDataBean.CategoryBean> category) {
        this.mActivity = mActivity;
        this.category = category;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       switch (viewType){
           case ITEM_TYPE_HEADER:
               View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_home_head,null);
               return new HomeHeadViewHolder(view);
           case ITEM_TYPE_CONTENT:
               View contentView = LayoutInflater.from(mActivity).inflate(R.layout.fragment_home_content,null);
               return new HomeContntViewHolder(contentView);
           case ITEM_TYPE_FOOT:
               View footView = LayoutInflater.from(mActivity).inflate(R.layout.fragment_home_head,null);
               return new HomeFootViewHolder(footView);

       }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HomeContntViewHolder){
            HomeContntViewHolder contntViewHolder = (HomeContntViewHolder) holder;

            Glide.with(mActivity).load(category.get(position-1).getImageUrl())
                    .error(R.mipmap.zhanwei4)
                    .placeholder(R.mipmap.zhanwei4).into(contntViewHolder.mIvImg);
            contntViewHolder.mTvTitl.setText(category.get(position-1).getTitle());
        }else if(holder instanceof HomeHeadViewHolder){
            HomeHeadViewHolder headViewHolder = (HomeHeadViewHolder) holder;
            headViewHolder.mBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                    Glide.with(banner.getContext()).load(model).placeholder(R.mipmap.zhanwei2)
                            .error(R.mipmap.zhanwei2)
                            .into((ImageView) view);
                }
            });

            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> text = new ArrayList<>();
            arrayList.clear();
            text.clear();
            if (topBanner != null) {
                if (topBanner.size() > 0) {
                    for (int i = 0; i < topBanner.size(); i++) {
                        text.add("");
                        arrayList.add(topBanner.get(i).getImageUrl());
                    }
                }
            }

            headViewHolder.mBanner.setData(R.layout.view_image, arrayList, text);
        }else if(holder instanceof HomeFootViewHolder){
            HomeFootViewHolder footViewHolder = (HomeFootViewHolder) holder;
            footViewHolder.mBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                    Glide.with(banner.getContext()).load(model).placeholder(R.mipmap.zhanwei2)
                            .error(R.mipmap.zhanwei2)
                            .into((ImageView) view);
                }
            });

            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> text = new ArrayList<>();
            arrayList.clear();
            text.clear();
            if (bottomBanner != null) {
                if (bottomBanner.size() > 0) {
                    for (int i = 0; i < bottomBanner.size(); i++) {
                        text.add("");
                        arrayList.add(bottomBanner.get(i).getImageUrl());
                    }
                }
            }

            footViewHolder.mBanner.setData(R.layout.view_image, arrayList, text);

        }
    }

    @Override
    public int getItemCount() {
        return category.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
       if(position==0){
           return ITEM_TYPE_HEADER;
       }else if(position == getItemCount()-1){
           return ITEM_TYPE_FOOT;
       }
        return ITEM_TYPE_CONTENT;

    }

    public void setHeadAndFootDate(List<HomeBean.HomeDataBean.TopBannerBean> topBanner, List<HomeBean.HomeDataBean.BottonBannerBean> bottonBanner) {
        this.topBanner = topBanner;
        this.bottomBanner = bottonBanner;
    }

    private class HomeHeadViewHolder extends RecyclerView.ViewHolder {

        private  BGABanner mBanner;

        public HomeHeadViewHolder(View view) {
            super(view);
            AutoUtils.auto(view);
            mBanner = (BGABanner) view.findViewById(R.id.banner);

        }
    }

    private class HomeFootViewHolder extends RecyclerView.ViewHolder {
        private  BGABanner mBanner;

        public HomeFootViewHolder(View footView) {
            super(footView);
            AutoUtils.auto(footView);
            mBanner = (BGABanner) footView.findViewById(R.id.banner);
        }
    }

    private class HomeContntViewHolder extends RecyclerView.ViewHolder {

        private  ImageView mIvImg;
        private  TextView mTvTitl;

        public HomeContntViewHolder(View contentView) {
            super(contentView);
            mIvImg = (ImageView) contentView.findViewById(R.id.image);
            mTvTitl = (TextView) contentView.findViewById(R.id.text);

        }
    }
}
