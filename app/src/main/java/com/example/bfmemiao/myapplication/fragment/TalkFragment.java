package com.example.bfmemiao.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmemiao.myapplication.Constant;
import com.example.bfmemiao.myapplication.R;
import com.example.bfmemiao.myapplication.adapter.TalkRecycleViewAdapter;
import com.example.bfmemiao.myapplication.utils.LogUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class TalkFragment extends BaseFragment {

    private static final String TAG = TalkFragment.class.getSimpleName();
    private RecyclerView mRecycleView;
    private TalkRecycleViewAdapter talkRecycleViewAdapter;

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
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(staggeredGridLayoutManager);

        talkRecycleViewAdapter = new TalkRecycleViewAdapter(mActivity);

        mRecycleView.setAdapter(talkRecycleViewAdapter);
        request();
    }

    private void request() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("pageSiz","1");
            jsonObject.put("userId","1");
            jsonObject.put("pageNo","2");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(Constant.JSON, jsonObject.toString());
        Request request = new Request.Builder()
                .url(Constant.URL + "UGCTopic/SearchUGCTopicsList")
                .post(body)
                .build();


        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.LogMC(TAG, e.toString());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                LogUtil.LogMC(TAG, result);
//                Message msg = Message.obtain();
//                msg.what = 0;
//                msg.obj = result;
//                handler.sendMessage(msg);

            }
        });


    }
}
