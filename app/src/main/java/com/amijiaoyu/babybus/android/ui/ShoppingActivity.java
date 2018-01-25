package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/24 13:38
 * Email:imkobedroid@gmail.com
 *
 * @author Dsh
 */

public class ShoppingActivity extends RxActivity
    implements BaseQuickAdapter.OnItemChildClickListener, View.OnClickListener {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.tv_toolbar_right) TextView tvToolbarRight;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.all_select) AppCompatImageView allSelect;
    @BindView(R.id.move) AppCompatTextView move;
    @BindView(R.id.recycleView) RecyclerView recycleView;
    public static List<Integer> integers;
    private List<LoginBean> container;
    private List<LoginBean> loginBeans;
    private ShoppingAdapter shoppingAdapter;
    private boolean isSelect = false;

    @Override protected int getLayout() {
        return R.layout.activity_loan_shopping;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar, tvToolbar, getString(R.string.CAR));
        tvToolbarRight.setText(getString(R.string.finish));
        initListener();
        initRecycleView();
    }

    private void initListener() {
        allSelect.setOnClickListener(this);
        move.setOnClickListener(this);
    }

    private void initRecycleView() {
        container = new ArrayList<>();
        integers = new ArrayList<>();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        shoppingAdapter = new ShoppingAdapter(loginBeans);
        shoppingAdapter.setOnItemChildClickListener(this);
        shoppingAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recycleView.setAdapter(shoppingAdapter);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
        if (integers.contains(view.getTag())) {
            integers.remove(view.getTag());
            ((ImageView) view).setImageResource(R.mipmap.selected_normal);
            allSelect.setImageResource(R.mipmap.selected_normal);
            isSelect = false;
        } else {
            integers.add(position);
            ((ImageView) view).setImageResource(R.mipmap.selected_highlight);
        }
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.all_select:
                setSelectData();
                break;
            case R.id.move:
                getSelectFinalData();
                break;
            default:
        }
    }

    private void getSelectFinalData() {
        //两次循环防止删除下标越界
        container.clear();
        for (int a = 0; a < integers.size(); a++) {
            container.add(loginBeans.get(integers.get(a)));
        }

        for (int a = 0; a < container.size(); a++) {
            if (loginBeans.contains(container.get(a))) {
                loginBeans.remove(container.get(a));
            }
        }

        integers.clear();
        shoppingAdapter.notifyDataSetChanged();
    }

    private void setSelectData() {
        isSelect = !isSelect;
        allSelect.setImageResource(R.mipmap.selected_highlight);
        if (isSelect) {
            integers.clear();
            for (int a = 0; a < loginBeans.size(); a++) {
                integers.add(a);
            }
            shoppingAdapter.notifyDataSetChanged();
        } else {
            allSelect.setImageResource(R.mipmap.selected_normal);
            integers.clear();
            shoppingAdapter.notifyDataSetChanged();
        }
    }
}
