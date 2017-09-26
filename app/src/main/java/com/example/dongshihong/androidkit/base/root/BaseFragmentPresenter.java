package com.example.dongshihong.androidkit.base.root;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public interface BaseFragmentPresenter<T extends BaseFragmentView>{

    void attachView(T view);

    void detachView();
}
