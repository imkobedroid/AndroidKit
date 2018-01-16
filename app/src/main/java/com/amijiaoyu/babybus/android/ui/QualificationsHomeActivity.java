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
 * Created by moerlong on 2018/1/16.
 */

public class QualificationsHomeActivity extends RxActivity {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.add_data)
    AppCompatImageView add_data;

    @Override
    protected int getLayout() {
        return R.layout.activity_qualifications_home;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.dialog_sheet, null);
            @SuppressLint("InflateParams") View mortgage = getLayoutInflater().inflate(R.layout.item_mortgage, null);
            @SuppressLint("InflateParams") View full = getLayoutInflater().inflate(R.layout.item_full, null);
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
        });
    }
}
