package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import java.util.ArrayList;

import butterknife.BindView;
import java.util.List;

/**
 * @author Dsh
 * @date 2018/1/16
 */

public class QualificationsHomeActivity extends RxActivity {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycleView) RecyclerView recycleView;
    @BindView(R.id.add_data) AppCompatImageView add_data;

    private static final int HOME_VALUATIONS = 1;
    private static final int HOME_NUMBER = 2;
    private static final int HOME_TIME = 3;

    String[] valuations = new String[] { "估值", "估值", "估值", "估值", "估值" };
    String[] number = new String[] { "期数", "期数", "期数", "期数", "期数" };
    String[] time = new String[] { "持有时间", "持有时间", "持有时间", "持有时间", "持有时间" };

    @Override protected int getLayout() {
        return R.layout.activity_qualifications_home;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, tvToolbar, getString(R.string.House));
        HouseAdapter adapter = new HouseAdapter(new ArrayList<>());
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapter);
        add_data.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_sheet, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_mortgage, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_full, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                adapter.addFooterView(mortgage);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                sheetDialog.dismiss();
                adapter.addFooterView(full);
            });
            sheetDialog.show();
            mortgage.findViewById(R.id.delete)
                .setOnClickListener(v1 -> adapter.removeFooterView(mortgage));

            if (mortgage != null) {
                AppCompatTextView valuation = mortgage.findViewById(R.id.valuation);
                valuation.setOnClickListener(v1 -> onClick(valuation, HOME_VALUATIONS));

                AppCompatTextView repayment_month = mortgage.findViewById(R.id.repayment_month);
                repayment_month.setOnClickListener(v1 -> onClick(repayment_month, HOME_NUMBER));
            }

            if (full != null) {
                AppCompatTextView time = full.findViewById(R.id.time);
                time.setOnClickListener(v1 -> onClick(time, HOME_TIME));
            }

            full.findViewById(R.id.delete).setOnClickListener(v1 -> adapter.removeFooterView(full));
        });
    }

    public void onClick(AppCompatTextView v, int type) {
        switch (type) {
            case HOME_VALUATIONS:
                showSelectItem(initData(valuations), v);
                break;
            case HOME_NUMBER:
                showSelectItem(initData(number), v);
                break;
            case HOME_TIME:
                showSelectItem(initData(time), v);
                break;
            default:
        }
    }

    private void showSelectItem(List<String> data, AppCompatTextView appCompatTextView) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View layout = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
        bottomSheetDialog.setContentView(layout);
        RecyclerView recyclerView = layout.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SheetAdapter sheetAdapter = new SheetAdapter(data);
        sheetAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            appCompatTextView.setText(data.get(i));
            bottomSheetDialog.dismiss();
        });
        recyclerView.setAdapter(sheetAdapter);
        bottomSheetDialog.show();
    }

    private ArrayList<String> initData(String[] data) {
        ArrayList<String> strings = new ArrayList<>();
        for (String str : data) {
            strings.add(str);
        }
        return strings;
    }
}
