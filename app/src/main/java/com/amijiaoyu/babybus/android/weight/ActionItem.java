package com.amijiaoyu.babybus.android.weight;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Date:2018/1/18 09:58
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class ActionItem {
    /**
     * 定义图片对象
     */
    public Drawable mDrawable;
    /**
     * 定义文本对象
     */
    public CharSequence mTitle;

    public ActionItem(Context context, CharSequence title, int drawableId) {
        this.mTitle = title;
        this.mDrawable = ContextCompat.getDrawable(context, drawableId);
    }
}
