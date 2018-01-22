package com.amijiaoyu.babybus.android.ui;

import android.support.annotation.Nullable;
import com.amijiaoyu.babybus.android.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.common.base.Strings;
import java.util.List;

/**
 * Author:SHIHONG DONG
 * Date:2018/1/22 14:37
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */

public class SheetAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SheetAdapter(List<String> data) {
        super(R.layout.item_dialog_sheet, data);
    }

    @Override protected void convert(BaseViewHolder baseViewHolder, String s) {
        if (!Strings.isNullOrEmpty(s)){
            baseViewHolder.setText(R.id.item,s);
        }
    }
}
