package com.example.dongshihong.androidkit.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
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
