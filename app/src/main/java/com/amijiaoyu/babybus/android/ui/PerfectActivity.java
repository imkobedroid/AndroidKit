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

import io.reactivex.Flowable;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by moerlong on 2018/1/16.
 */

public class PerfectActivity extends RxActivity {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.add_data_home) AppCompatImageView addDataHome;
    @BindView(R.id.recycleView_home) RecyclerView recycleViewHome;
    @BindView(R.id.add_data_car) AppCompatImageView addDataCar;
    @BindView(R.id.recycleView_car) RecyclerView recycleViewCar;
    @BindView(R.id.add_data_policy) AppCompatImageView addDataPolicy;
    @BindView(R.id.recycleView_policy) RecyclerView recycleViewPolicy;

    @Override protected int getLayout() {
        return R.layout.activity_perfect;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {

        //房产
        initToolBar(toolbar, tvToolbar, getString(R.string.perfect));
        HouseAdapter homeAdapter = new HouseAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleViewHome.setLayoutManager(layoutManager);
        //解决嵌套的滑动问题
        recycleViewHome.setNestedScrollingEnabled(false);
        recycleViewHome.setAdapter(homeAdapter);
        addDataHome.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_sheet, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_perfect_home, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_perfect_full, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                homeAdapter.addFooterView(mortgage);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                sheetDialog.dismiss();
                homeAdapter.addFooterView(full);
            });

            mortgage.findViewById(R.id.delete)
                .setOnClickListener(v1 -> homeAdapter.removeFooterView(mortgage));
            full.findViewById(R.id.delete)
                .setOnClickListener(v1 -> homeAdapter.removeFooterView(full));

            sheetDialog.show();
        });

        //车子
        HouseAdapter carAdapter = new HouseAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        recycleViewCar.setLayoutManager(layoutManager1);
        //解决嵌套的滑动问题
        recycleViewCar.setNestedScrollingEnabled(false);
        recycleViewCar.setAdapter(carAdapter);
        addDataCar.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_car_sheet, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_car, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_full_car, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                carAdapter.addFooterView(mortgage);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                sheetDialog.dismiss();
                carAdapter.addFooterView(full);
            });
            sheetDialog.show();
        });

        //保单
        HouseAdapter policyAdapter = new HouseAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        recycleViewPolicy.setLayoutManager(layoutManager2);
        //解决嵌套的滑动问题
        recycleViewPolicy.setNestedScrollingEnabled(false);
        recycleViewPolicy.setAdapter(policyAdapter);
        addDataPolicy.setOnClickListener(v -> {
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.item_policy, null);
            policyAdapter.addHeaderView(view);
        });
    }
}