package com.amijiaoyu.babybus.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.base.root.BaseActivity;
import com.amijiaoyu.babybus.android.base.root.BaseActivityPresenter;
import com.amijiaoyu.babybus.android.base.root.BaseActivityView;
import com.amijiaoyu.babybus.android.di.component.ActivityComponent;
import com.amijiaoyu.babybus.android.di.component.DaggerActivityComponent;
import com.amijiaoyu.babybus.android.di.module.ActivityModule;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */
public abstract class RxActivity<T extends BaseActivityPresenter>
    extends BaseActivity implements BaseActivityView {

    @Inject
    protected T mPresenter;
    private Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectActivity();
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
            .appComponent(App.getAppComponent())
            .activityModule(new ActivityModule(this))
            .build();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void injectActivity() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initToolBar(Toolbar toolbar, TextView mTvToolbar, String title) {
        toolbar.setTitle("");
        mTvToolbar.setText(title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(view -> finish());
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    /**
     * 提供注册界面的方法
     */
    protected abstract void initInject();


    /**
     * 获取权限
     * @param permissions 要获取的权限
     * @return 是否获取成功
     */
    public boolean getRxPermission(final String... permissions) {
        final boolean[] succeed = {false};
        RxPermissions rxPermissions = new RxPermissions(this);
        disposable = rxPermissions.requestEach(permissions).subscribe(permission -> {

            if (permission.granted){
                //用户同意了权限
                succeed[0] =true;

            }else if (permission.shouldShowRequestPermissionRationale){
                 //用户拒绝了权限没有选中不再显示
                succeed[0] =false;

            }else {
                 //用于拒绝了权限并选择了不再显示
                succeed[0] =false;
            }

        }, throwable -> succeed[0] =false);
        return succeed[0];
    }
}