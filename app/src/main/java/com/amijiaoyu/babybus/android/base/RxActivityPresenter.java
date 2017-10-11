package com.amijiaoyu.babybus.android.base;

import com.amijiaoyu.babybus.android.base.root.BaseActivityPresenter;
import com.amijiaoyu.babybus.android.base.root.BaseActivityView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public class RxActivityPresenter<T extends BaseActivityView> implements BaseActivityPresenter<T> {

  public T mView;
  private CompositeDisposable mCompositeDisposable;

  private void unSubscribe() {
    if (mCompositeDisposable != null) {
      mCompositeDisposable.dispose();
    }
  }

  protected void addSubscribe(Disposable subscription) {
    if (mCompositeDisposable == null) {
      mCompositeDisposable = new CompositeDisposable();
    }
    mCompositeDisposable.add(subscription);
  }

  @Override public void attachView(T view) {
    this.mView = view;
  }

  @Override public void detachView() {
    this.mView = null;
    unSubscribe();
  }
}
