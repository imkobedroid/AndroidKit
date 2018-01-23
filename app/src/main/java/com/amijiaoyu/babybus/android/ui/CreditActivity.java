package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Dsh
 * @date 2018/1/16
 */

public class CreditActivity extends RxActivity {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycleView) RecyclerView recycleView;
    @BindView(R.id.add_data) AppCompatImageView add_data;

    @Override protected int getLayout() {
        return R.layout.activity_credit;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, tvToolbar, getString(R.string.fill_car));
        HouseAdapter adapter = new HouseAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        //解决嵌套的滑动问题
        recycleView.setNestedScrollingEnabled(false);
        recycleView.setAdapter(adapter);
        add_data.setOnClickListener(v -> {
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.item_credit, null);
            adapter.addHeaderView(view);
        });
    }
}