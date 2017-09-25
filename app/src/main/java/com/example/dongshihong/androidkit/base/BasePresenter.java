package com.example.dongshihong.androidkit.base;

/**
 * Author:SHIHONG DONG
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
