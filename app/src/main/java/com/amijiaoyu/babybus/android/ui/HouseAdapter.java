package com.amijiaoyu.babybus.android.ui;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 *
 * @author Dsh
 * @date 2018/1/16
 */

public class HouseAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public HouseAdapter( @Nullable List<String> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {

    }
}
