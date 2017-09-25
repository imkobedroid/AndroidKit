package com.example.dongshihong.androidkit.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

public abstract class SimpleFragment extends Fragment {

  protected View mView;
  protected Activity mActivity;
  protected Context mContext;
  private Unbinder mUnBinder;
  //暂时不考虑内存重启的情况
  //protected boolean isInited = false;

  @Override public void onAttach(Context context) {
    mActivity = (Activity) context;
    mContext = context;
    super.onAttach(context);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mView = inflater.inflate(getLayoutId(), null);
    mUnBinder = ButterKnife.bind(this, mView);
    return mView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    mUnBinder.unbind();
  }

  protected abstract int getLayoutId();

}
