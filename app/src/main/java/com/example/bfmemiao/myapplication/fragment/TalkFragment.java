package com.example.bfmemiao.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmemiao.myapplication.R;
import com.example.bfmemiao.myapplication.adapter.TalkRecycleViewAdapter;
import com.example.bfmemiao.myapplication.bean.TalkBean;
import com.example.bfmemiao.myapplication.mvp.presenter.HomePresenter;
import com.example.bfmemiao.myapplication.mvp.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class TalkFragment extends BaseFragment implements HomeView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = TalkFragment.class.getSimpleName();
    private RecyclerView mRecycleView;
    private TalkRecycleViewAdapter talkRecycleViewAdapter;

    private String pageSize = "10";
    private String pageNo = "1";
    private List<TalkBean.TopicsListBean> topicsList = new ArrayList<>();
    private HomePresenter homePresenter;
    private GridLayoutManager gridLayoutManager;
    private SwipeRefreshLayout mSwiperefresh;

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
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_talk,null);
        mRecycleView = (RecyclerView) view.findViewById(R.id.recycleview);
        mSwiperefresh = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mSwiperefresh.setColorSchemeResources(R.color.holo_blue_bright, R.color.holo_green_light,
                R.color.holo_orange_light, R.color.holo_red_light);
        mSwiperefresh.setOnRefreshListener(this);
        gridLayoutManager = new GridLayoutManager(mActivity, 2);
        gridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup(gridLayoutManager));
        mRecycleView.setLayoutManager(gridLayoutManager);


        talkRecycleViewAdapter = new TalkRecycleViewAdapter(mActivity,topicsList);
        mRecycleView.setAdapter(talkRecycleViewAdapter);

        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    int lastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();

                    if (gridLayoutManager.getItemCount() <= 1) {
                        return;
                    }
                    if (gridLayoutManager.getItemCount() <= 1) {
                        return;
                    }
                    if (lastVisiblePosition >= gridLayoutManager.getItemCount() - 1) {
                        if (talkRecycleViewAdapter != null) {
                            talkRecycleViewAdapter.showFootView();
                        }

                        int i = Integer.parseInt(pageNo);
                        i++;
                        pageNo = String.valueOf(i);
                        requestList();
                    }


                }
            }
        });

        homePresenter = new HomePresenter(this);
        requestList();
    }

    private void requestList() {
        homePresenter.requestTalk(pageSize,pageNo);
    }


    @Override
    public void showProcress() {
        showLoadingDialog();
    }

    @Override
    public void parserDate(Object data) {
        if(data instanceof TalkBean){
            TalkBean talkBean = (TalkBean) data;
            List<TalkBean.TopicsListBean> topicsList =
                    talkBean.getTopicsList();

            this.topicsList.addAll(topicsList);
            talkRecycleViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void hintProcress() {

        if(mSwiperefresh!=null){
            mSwiperefresh.setRefreshing(false);
        }
        dismissLoadingDialog();
    }

    @Override
    public void errorHandling(Throwable e) {

    }

    @Override
    public void onRefresh() {
        if (talkRecycleViewAdapter != null) {
            topicsList.clear();
            talkRecycleViewAdapter.hintFootView();
            talkRecycleViewAdapter.notifyDataSetChanged();
            pageNo = "1";
            requestList();
        }
    }

    class HeaderSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

        private final GridLayoutManager layoutManager;

        public HeaderSpanSizeLookup(GridLayoutManager layoutManager) {
            this.layoutManager = layoutManager;
        }

        //在这里设置头布局和脚布局占用的条数
        @Override
        public int getSpanSize(int position) {

            if (
                    talkRecycleViewAdapter.getItemViewType(position) == talkRecycleViewAdapter.ITEM_TYPE_HEADER ||

                            talkRecycleViewAdapter.getItemViewType(position) == talkRecycleViewAdapter.ITEM_TYPE_EMPTY ||
                            talkRecycleViewAdapter.getItemViewType(position) == talkRecycleViewAdapter.ITEM_TYPE_FOOT) {
                return 2;
            }
            return 1;
        }
    }
}
