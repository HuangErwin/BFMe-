package com.example.bfmemiao.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bfmemiao.myapplication.BaseActivity;
import com.example.bfmemiao.myapplication.R;

import java.util.Random;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class TalkRecycleViewAdapter extends BaseRecycleViewAdapter {
    private  BaseActivity mActivity;
    private Random random = new Random();

    public TalkRecycleViewAdapter(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_talk_content,null);
        return new TalkRecycleViewHoler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if(holder instanceof TalkRecycleViewHoler){
             TalkRecycleViewHoler holder1 = (TalkRecycleViewHoler) holder;

             boolean b = random.nextBoolean();
             if(b){
                 Glide.with(mActivity).load(R.mipmap.zhanwei4)
                         .into(holder1.mIvImage);
             }else {
                 Glide.with(mActivity).load(R.mipmap.zhanwei2)
                         .into(holder1.mIvImage);
             }

         }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private class TalkRecycleViewHoler extends RecyclerView.ViewHolder {

        private  ImageView mIvImage;

        public TalkRecycleViewHoler(View view) {
            super(view);
            mIvImage = (ImageView) view.findViewById(R.id.image);


        }
    }
}
