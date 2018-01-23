package com.example.bfmemiao.myapplication.utils;



import com.example.bfmemiao.myapplication.fragment.BaseFragment;
import com.example.bfmemiao.myapplication.fragment.CategoryFragment;
import com.example.bfmemiao.myapplication.fragment.HomeFragment;
import com.example.bfmemiao.myapplication.fragment.TalkFragment;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2016/11/30.
 */
public class FragmentFactory {

    public static final int FRAGEMENT_HOME = 0;
    public static final int FRAGEMENT_CATEGORY = 1;
    public static final int FRAGEMENT_TALK= 2;
    public static FragmentFactory instances;
    public static FragmentFactory getInstances(){
        if(instances == null){
            instances = new FragmentFactory();
        }
        return instances;
    }

    private static WeakHashMap<Integer, BaseFragment> mFragmentCache = new WeakHashMap<>();

    public BaseFragment createFragment(int position){
        BaseFragment fragment = mFragmentCache.get(position);
        if (fragment == null) {
            switch (position) {
                case FRAGEMENT_HOME:
                    fragment = new HomeFragment();
                    break;
                case FRAGEMENT_CATEGORY:
                    fragment = new CategoryFragment();
                    break;
                case FRAGEMENT_TALK:
                    fragment = new TalkFragment();
                    break;

                default:
                    break;
            }
            mFragmentCache.put(position,fragment);
        }
        return fragment;
    }

    public static void clear(){
        mFragmentCache.clear();
    }
}
