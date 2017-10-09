package com.example.dongshihong.androidkit.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.example.dongshihong.androidkit.base.root.BaseFragmentPresenter;
import com.example.dongshihong.androidkit.base.root.BaseFragmentView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public class RxFragmentPresenter<T extends BaseFragmentView> implements BaseFragmentPresenter<T> {

  private T mView;
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

  protected Activity getSuperActivity() {
    if (mView!=null){
      return ((Fragment) mView).getActivity();
    }
    return null;
  }

  @Override public void attachView(T view) {
    this.mView = view;
  }

  @Override public void detachView() {
    this.mView = null;
    unSubscribe();
  }
}
