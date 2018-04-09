package com.amijiaoyu.babybus.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.amijiaoyu.babybus.android.app.App;
import com.amijiaoyu.babybus.android.base.root.BaseFragment;
import com.amijiaoyu.babybus.android.base.root.BaseFragmentPresenter;
import com.amijiaoyu.babybus.android.base.root.BaseFragmentView;
import com.amijiaoyu.babybus.android.di.component.DaggerFragmentComponent;
import com.amijiaoyu.babybus.android.di.component.FragmentComponent;
import com.amijiaoyu.babybus.android.di.module.FragmentModule;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */
public abstract class RxFragment<T extends BaseFragmentPresenter> extends BaseFragment
    implements BaseFragmentView {

  @Inject protected T mPresenter;

  private Disposable disposable;

  @Override public FragmentComponent getFragmentComponent() {
    return DaggerFragmentComponent.builder()
        .appComponent(App.getAppComponent())
        .fragmentModule(new FragmentModule(this))
        .build();
  }

  @SuppressWarnings("unchecked") @Override public void injectFragment() {
    initInject();
    if (mPresenter != null) {
      mPresenter.attachView(this);
    }
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectFragment();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (mPresenter != null) {
      mPresenter.detachView();
    }

    if (disposable!=null&&!disposable.isDisposed()){
        disposable.dispose();
    }
  }


    /**
     * 连接presenter
     */
  protected abstract void initInject();


    /**
     * 获取权限
     * @param permissions 要获取的权限
     * @return 是否获取成功
     */
    public boolean getRxPermission(final String... permissions) {
        final boolean[] succeed = {false};
        RxPermissions rxPermissions = new RxPermissions(this.getActivity());
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