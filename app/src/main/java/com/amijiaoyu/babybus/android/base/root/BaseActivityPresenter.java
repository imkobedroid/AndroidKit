package com.amijiaoyu.babybus.android.base.root;

/**
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 * @author dongshihong
 */
public interface BaseActivityPresenter<T extends BaseActivityView>{
  /**
   * 界面与presenter的连接
   */
    void attachView(T view);

  /**
   * 断开界面与presenter的连接
   */
    void detachView();
}
