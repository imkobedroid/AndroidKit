package com.amijiaoyu.babybus.android.base;

import com.amijiaoyu.babybus.android.base.root.BaseFragment;

/**
 * Created by Dsh on 2017/5/16.
 * Use:
 */

public abstract class RxLazLoadFragment extends BaseFragment {
    protected boolean isVisible;
    public boolean isPrepared = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    private void onInVisible() {
    }

    private void onVisible() {
        loadData();
    }

    protected abstract void loadData();
}

