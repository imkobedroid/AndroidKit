package com.example.dongshihong.androidkit.base;

import com.example.dongshihong.androidkit.base.root.BasePresenter;
import com.example.dongshihong.androidkit.base.root.BaseView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

  protected T mView;
  protected CompositeDisposable mCompositeDisposable;

  protected void unSubscribe() {
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
