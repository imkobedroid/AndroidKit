package com.example.dongshihong.androidkit.base.root;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

public abstract class BaseFragment extends Fragment {

  protected View mView;
  private Unbinder mUnBinder;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mView = inflater.inflate(getLayoutId(), null);
    mUnBinder = ButterKnife.bind(this, mView);
    return mView;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    mUnBinder.unbind();
  }

  protected abstract int getLayoutId();
}
