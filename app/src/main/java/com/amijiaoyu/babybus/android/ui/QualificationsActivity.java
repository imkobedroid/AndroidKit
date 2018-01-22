package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moerlong
 * @date 2018/1/16
 */

@SuppressLint("Registered") public class QualificationsActivity extends RxActivity
    implements View.OnClickListener {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.property) AppCompatTextView property;
    @BindView(R.id.car) AppCompatTextView car;
    @BindView(R.id.good_job) AppCompatTextView good_job;
    @BindView(R.id.credit) AppCompatTextView credit;
    @BindView(R.id.repayment_month) AppCompatTextView repayment_month;
    @BindView(R.id.handle) AppCompatTextView handle;

    String[] strings = new String[] { "测试1", "测试2", "测试3", "测试4", "测试5" };

    private static final int SELECT_GOOD_JOB = 1;
    private static final int SELECT_CREDIT = 2;
    private static final int SELECT_MONTH = 3;
    private static final int SELECT_LATELY = 4;

    @Override protected int getLayout() {
        return R.layout.activity_qualification;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar, tvToolbar, getString(R.string.match));
        property.setOnClickListener(
            v -> startActivity(new Intent(this, QualificationsHomeActivity.class)));
        car.setOnClickListener(
            v -> startActivity(new Intent(this, QualificationsCarActivity.class)));
        initListener();
    }

    private void initListener() {
        credit.setOnClickListener(this);
        good_job.setOnClickListener(this);
        repayment_month.setOnClickListener(this);
        handle.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.good_job:
                showSelectItem(initData(strings), SELECT_GOOD_JOB);
                break;
            case R.id.credit:
                showSelectItem(initData(strings), SELECT_CREDIT);
                break;
            case R.id.repayment_month:
                showSelectItem(initData(strings), SELECT_MONTH);
                break;
            case R.id.handle:
                showSelectItem(initData(strings), SELECT_LATELY);
                break;
            default:
        }
    }

    private void showSelectItem(List<String> data, int index) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View layout = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
        bottomSheetDialog.setContentView(layout);
        RecyclerView recyclerView = layout.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SheetAdapter sheetAdapter = new SheetAdapter(data);
        sheetAdapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            switch (index) {
                case SELECT_GOOD_JOB:
                    good_job.setText(data.get(i));
                    bottomSheetDialog.dismiss();
                    break;
                case SELECT_CREDIT:
                    credit.setText(data.get(i));
                    bottomSheetDialog.dismiss();
                    break;
                case SELECT_MONTH:
                    repayment_month.setText(data.get(i));
                    bottomSheetDialog.dismiss();
                    break;
                case SELECT_LATELY:
                    handle.setText(data.get(i));
                    bottomSheetDialog.dismiss();
                    break;
                default:

            }
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
