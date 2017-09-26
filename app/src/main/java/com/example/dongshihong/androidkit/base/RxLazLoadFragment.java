package com.example.dongshihong.androidkit.base;

import com.example.dongshihong.androidkit.base.root.BaseFragment;

/**
 * Created by Dsh on 2017/5/16.
 * Use:
 */

public abstract class RxLazLoadFragment extends BaseFragment {
    protected boolean isVisble;
    public boolean isPrepared = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisble = true;
            onVisible();
        } else {
            isVisble = false;
            onInVisible();
        }
    }

    protected void onInVisible() {
    }

    protected void onVisible() {
        loadData();
    }

    protected abstract void loadData();
}

