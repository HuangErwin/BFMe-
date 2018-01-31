package com.example.bfmemiao.myapplication;

import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.bfmemiao.myapplication.fragment.BaseFragment;
import com.example.bfmemiao.myapplication.utils.FragmentFactory;
import com.example.bfmemiao.myapplication.utils.TUtils;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private FragmentFactory instances;
    private BaseFragment fragment;
    private BaseFragment mTempFragment;

    private RadioButton mRootHome;
    private RadioButton mRootCategory;
    private RadioButton mRootPersonal;

    @Override
    protected void setupView() {
        setTheme(android.R.style.Theme_Material_Wallpaper_NoTitleBar);
        setContentView(R.layout.activity_main);
//        WallpaperManager manager = WallpaperManager.getInstance(this);
//        Drawable drawable = manager.getDrawable();
//        ImageView mIvImg = (ImageView) findViewById(R.id.ivimage);
//        mIvImg.setImageDrawable(drawable);


        instances = FragmentFactory.getInstances();
        int position = getIntent().getIntExtra("position", 0);
        fragment = instances.createFragment(position);
        getSupportFragmentManager().beginTransaction().add(R.id.main_fl_container, fragment).commit();
        mTempFragment = fragment;
    }

    @Override
    protected void addListener() {
        RadioGroup mRgRoot = (RadioGroup) findViewById(R.id.main_rg_container);

        mRootHome = (RadioButton) findViewById(R.id.main_rb_home);
        mRootCategory = (RadioButton) findViewById(R.id.main_rb_category);
        mRootPersonal = (RadioButton) findViewById(R.id.main_rb_personal);
        mRgRoot.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        BaseFragment fragment = null;
        switch (checkedId) {
            case R.id.main_rb_home:
                fragment = instances.createFragment(0);
                break;
            case R.id.main_rb_category:
                fragment = instances.createFragment(1);
                break;
            case R.id.main_rb_personal:
                fragment = instances.createFragment(2);
                break;
        }

        if (fragment != null && fragment != mTempFragment) {
            if (!fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.main_fl_container, fragment)
                        .hide(mTempFragment)
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .hide(mTempFragment)
                        .show(fragment).commit();
            }
            mTempFragment = fragment;

        }

    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                TUtils.showToast(getApplication(), "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
