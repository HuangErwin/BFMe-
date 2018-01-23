package com.example.bfmemiao.myapplication.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bfmemiao.myapplication.BaseActivity;
import com.example.bfmemiao.myapplication.R;
import com.example.bfmemiao.myapplication.bean.CategoryAllBean;
import com.example.bfmemiao.myapplication.fragment.CategoryFragment;
import com.example.bfmemiao.myapplication.listener.OnItemCoustomClickListener;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class CategoryLeftRecycleViewAdapter extends BaseRecycleViewAdapter {
    private  List<CategoryAllBean.CategoryBean> category;
    private  BaseActivity mActivity;


    public CategoryLeftRecycleViewAdapter(BaseActivity mActivity, List<CategoryAllBean.CategoryBean> category) {
        this.mActivity = mActivity;
        this.category = category;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_category_left_content,null);
        return new CategoryContentViewHolder(view,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CategoryContentViewHolder){
            CategoryContentViewHolder holder1 = (CategoryContentViewHolder) holder;
            holder1.mTvTitle.setText(category.get(position).getName());
            if(position== CategoryFragment.CURRENT_POSITION){
                holder1.mTvTitle.setTextColor(Color.parseColor("#1C4D8F"));
            }else {
                holder1.mTvTitle.setTextColor(Color.parseColor("#333333"));
            }
        }
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    private class CategoryContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private  OnItemCoustomClickListener mItemClickListener;
        private  TextView mTvTitle;

        public CategoryContentViewHolder(View view, OnItemCoustomClickListener mItemClickListener) {
            super(view);
            this.mItemClickListener = mItemClickListener;
            view.setOnClickListener(this);
            mTvTitle = (TextView) view.findViewById(R.id.category_tv_left);

        }

        @Override
        public void onClick(View view) {
            if(mItemClickListener!=null){
                mItemClickListener.onItemClick(view,getPosition());
            }
        }
    }
}
