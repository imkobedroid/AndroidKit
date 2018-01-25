package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;

/**
 * @author moerlong
 * @date 2018/1/16
 */

@SuppressLint("Registered") public class QualificationsEditActivity extends RxActivity
    implements View.OnClickListener {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    String[] strings1 = new String[] { "优质行业", "优质行业", "优质行业", "优质行业", "优质行业" };
    String[] strings2 = new String[] { "授权额度", "授权额度", "授权额度", "授权额度", "授权额度" };
    String[] strings3 = new String[] { "抵押还款", "抵押还款", "抵押还款", "抵押还款", "抵押还款" };
    String[] strings4 = new String[] { "信用卡", "信用卡", "信用卡", "信用卡", "信用卡" };

    private static final int EDIT_GOOD_JOB = 1;
    private static final int EDIT_QUOTA = 2;
    private static final int EDIT_REPAYMENT = 3;
    private static final int EDIT_CARD = 4;
    @BindView(R.id.good_job) AppCompatTextView goodJob;
    @BindView(R.id.credit) AppCompatTextView credit;
    @BindView(R.id.repayment_month) AppCompatTextView repaymentMonth;
    @BindView(R.id.handle) AppCompatTextView handle;

    @Override protected int getLayout() {
        return R.layout.activity_qualification_edit;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        initToolBar(toolbar, tvToolbar, getString(R.string.edit_need));
    }

    private void initListener() {
        goodJob.setOnClickListener(this);
        credit.setOnClickListener(this);
        repaymentMonth.setOnClickListener(this);
        handle.setOnClickListener(this);
    }

    public void onClick(AppCompatTextView v, int type) {
        switch (type) {
            case EDIT_GOOD_JOB:
                showSelectItem(initData(strings1), v);
                break;
            case EDIT_QUOTA:
                showSelectItem(initData(strings2), v);
                break;
            case EDIT_REPAYMENT:
                showSelectItem(initData(strings3), v);
                break;
            case EDIT_CARD:
                showSelectItem(initData(strings4), v);
                break;
            default:
        }
    }

    private void showSelectItem(List<String> data, AppCompatTextView appCompatTextView) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        @SuppressLint("InflateParams") View layout =
            getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
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
        Collections.addAll(strings, data);
        return strings;
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.good_job:
                onClick(goodJob, EDIT_GOOD_JOB);
                break;
            case R.id.credit:
                onClick(credit, EDIT_QUOTA);
                break;
            case R.id.repayment_month:
                onClick(repaymentMonth, EDIT_REPAYMENT);
                break;
            case R.id.handle:
                onClick(handle, EDIT_CARD);
                break;
        }
    }
}
