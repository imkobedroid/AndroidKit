package com.amijiaoyu.babybus.android.base.root;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public interface BaseFragmentPresenter<T extends BaseFragmentView>{

  /**
   * 得到fragment与presenter的连接
   */
    void attachView(T view);

  /**
   * 删除fragment与presenter的连接
   */
    void detachView();
}
