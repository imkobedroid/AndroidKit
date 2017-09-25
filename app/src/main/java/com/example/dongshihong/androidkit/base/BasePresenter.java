package com.example.dongshihong.androidkit.base;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
