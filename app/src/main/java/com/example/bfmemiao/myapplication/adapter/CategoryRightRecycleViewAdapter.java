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
import com.example.bfmemiao.myapplication.bean.CategoryAllBean;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class CategoryRightRecycleViewAdapter extends BaseRecycleViewAdapter {
    private  List<CategoryAllBean.CategoryBean> category;
    private  BaseActivity mActivity;

    public CategoryRightRecycleViewAdapter(BaseActivity mActivity, List<CategoryAllBean.CategoryBean> category) {
        this.mActivity = mActivity;
        this.category = category;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_category_right_content,null);
        return new CategoryContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CategoryContentViewHolder){
            CategoryContentViewHolder holder1 = (CategoryContentViewHolder) holder;
            holder1.mTvTitle.setText(category.get(position).getName());

            Glide.with(mActivity).load(category.get(position).getIcon())
                    .error(R.mipmap.zhanwei2)
                    .placeholder(R.mipmap.zhanwei2)
                    .into(holder1.mIvImg);
        }
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    private class CategoryContentViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;
        private  ImageView mIvImg;

        public CategoryContentViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) view.findViewById(R.id.tvtitle);
            mIvImg = (ImageView) view.findViewById(R.id.image);


        }

    }
}
