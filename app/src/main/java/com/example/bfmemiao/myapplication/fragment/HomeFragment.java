package com.example.bfmemiao.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmemiao.myapplication.R;
import com.example.bfmemiao.myapplication.adapter.HomeRecycleViewAdapter;
import com.example.bfmemiao.myapplication.bean.HomeBean;
import com.example.bfmemiao.myapplication.mvp.presenter.HomePresenter;
import com.example.bfmemiao.myapplication.mvp.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomeFragment extends BaseFragment implements HomeView {

    private static final String TAG =HomeFragment.class.getSimpleName();
    private RecyclerView mRecycleView;
    private List<HomeBean.HomeDataBean.CategoryBean> category = new ArrayList<>();
    private HomeRecycleViewAdapter homeRecycleViewAdapter;
    private HomePresenter homePresenter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,null);
        mRecycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridLayoutManager = new GridLayoutManager(mActivity, 2);
        gridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup(gridLayoutManager));
        mRecycleView.setLayoutManager(gridLayoutManager);

        homeRecycleViewAdapter = new HomeRecycleViewAdapter(mActivity,category);
        mRecycleView.setAdapter(homeRecycleViewAdapter);
        homePresenter = new HomePresenter(this);
        homePresenter.requestPost("1");
    }


    @Override
    public void showProcress() {
        mActivity.showLoadingDialog();
    }

    @Override
    public void parserDate(Object data) {
        if(data instanceof HomeBean){
            HomeBean homeBean = (HomeBean) data;
            HomeBean.HomeDataBean homeData = homeBean.getHomeData();
            List<HomeBean.HomeDataBean.CategoryBean> category = homeData.getCategory();
            this.category.clear();
            this.category.addAll(category);
            homeRecycleViewAdapter.setHeadAndFootDate(homeData.getTopBanner(),homeData.getBottonBanner());
            mRecycleView.setAdapter(homeRecycleViewAdapter);
            homeRecycleViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void hintProcress() {
        mActivity.dismissLoadingDialog();
    }

    @Override
    public void errorHandling(Throwable e) {

    }


    class HeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        private final GridLayoutManager layoutManager;

        public HeaderSpanSizeLookup(GridLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        //在这里设置头布局和脚布局占用的条数
        @Override
        public int getSpanSize(int position) {

            if (position == 0) {
                return 2;
            }
            if (
                    homeRecycleViewAdapter.getItemViewType(position) == homeRecycleViewAdapter.ITEM_TYPE_HEADER ||

                    homeRecycleViewAdapter.getItemViewType(position) == homeRecycleViewAdapter.ITEM_TYPE_EMPTY ||
                            homeRecycleViewAdapter.getItemViewType(position) == homeRecycleViewAdapter.ITEM_TYPE_FOOT) {
                return 2;
            }
            return 1;
        }
    }
}
