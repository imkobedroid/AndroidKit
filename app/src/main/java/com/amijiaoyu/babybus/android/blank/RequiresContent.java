package com.amijiaoyu.babybus.android.blank;

import android.view.View;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:43
 * Email:imkobedroid@gmail.com
 */

@Inherited @Retention(RetentionPolicy.RUNTIME) public @interface RequiresContent {

  Class<? extends View> loadView() default DefaultLoadView.class;

  Class<? extends View> emptyView() default DefaultEmptyView.class;

  Class<? extends View> errorView() default DefaultErrorView.class;
}
