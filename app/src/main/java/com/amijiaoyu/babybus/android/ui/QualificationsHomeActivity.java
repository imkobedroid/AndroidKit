package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Dsh
 * @date 2018/1/16
 */

public class QualificationsHomeActivity extends RxActivity implements View.OnClickListener {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recycleView) RecyclerView recycleView;
    @BindView(R.id.add_data) AppCompatImageView addData;
    @BindView(R.id.next) AppCompatButton next;
    @BindView(R.id.scrollView) NestedScrollView scrollView;

    private static final int HOME_NUMBER = 1;
    private static final int HOME_TIME = 2;
    private HouseAdapter adapter;
    private static final String TAG = "测试日志";
    String[] number = new String[] { "期数", "期数", "期数", "期数", "期数" };
    String[] time = new String[] { "持有时间", "持有时间", "持有时间", "持有时间", "持有时间" };
    private List<View> mortgageList;
    private List<View> fullList;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        initView();
    }

    @Override protected int getLayout() {
        return R.layout.activity_qualifications_home;
    }

    @Override protected void initInject() {

    }

    private void initListener() {
        next.setOnClickListener(this);
    }

    private void initView() {
        initToolBar(toolbar, tvToolbar, getString(R.string.House));
        mortgageList = new ArrayList<>();
        fullList = new ArrayList<>();
        adapter = new HouseAdapter(new ArrayList<>());
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapter);
        recycleView.setNestedScrollingEnabled(false);
        addData.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_sheet_home, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_mortgage, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_full, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                adapter.addFooterView(mortgage);
                //新加的尾布局加入到集合中方便后面手机数据
                mortgageList.add(mortgage);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                adapter.addFooterView(full);
                //新加的尾布局加入到集合中方便后面手机数据
                fullList.add(full);
                sheetDialog.dismiss();
            });
            sheetDialog.show();

            mortgage.findViewById(R.id.delete).setOnClickListener(v1 -> {
                adapter.removeFooterView(mortgage);
                removeView(mortgage);
            });

            if (mortgage != null) {
                AppCompatTextView valuation = mortgage.findViewById(R.id.time);
                valuation.setOnClickListener(v1 -> onClick(valuation, HOME_TIME));

                AppCompatTextView repayment_month = mortgage.findViewById(R.id.repayment_month);
                repayment_month.setOnClickListener(v1 -> onClick(repayment_month, HOME_NUMBER));
            }

            if (full != null) {
                AppCompatTextView time = full.findViewById(R.id.time);
                time.setOnClickListener(v1 -> onClick(time, HOME_TIME));
            }

            if (full.findViewById(R.id.delete) != null) {
                full.findViewById(R.id.delete).setOnClickListener(v1 -> {
                    adapter.removeFooterView(full);
                    removeView(full);
                });
            }
        });
    }

    public void onClick(AppCompatTextView v, int type) {
        switch (type) {
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
            case R.id.next:
                getFinalData();
                break;
            default:
        }
    }

    private void getFinalData() {
        for (int a = 0; a < fullList.size(); a++) {
            String valuation =
                ((AppCompatTextView) fullList.get(a).findViewById(R.id.valuation)).getText()
                    .toString();
            String time =
                ((AppCompatTextView) fullList.get(a).findViewById(R.id.time)).getText().toString();
            Log.v(TAG, "全款房 " + valuation + "  " + time);
        }
        for (int a = 0; a < mortgageList.size(); a++) {
            String valuation =
                ((AppCompatTextView) mortgageList.get(a).findViewById(R.id.valuation)).getText()
                    .toString();
            String balance =
                ((AppCompatEditText) mortgageList.get(a).findViewById(R.id.balance)).getText()
                    .toString();
            String time =
                ((AppCompatTextView) mortgageList.get(a).findViewById(R.id.time)).getText()
                    .toString();
            String month_money =
                ((AppCompatEditText) mortgageList.get(a).findViewById(R.id.month_money)).getText()
                    .toString();
            String repayment_month = ((AppCompatTextView) mortgageList.get(a)
                .findViewById(R.id.repayment_month)).getText().toString();
            Log.v(TAG, "按揭房 "
                + valuation
                + "  "
                + time
                + "  "
                + balance
                + "  "
                + month_money
                + "  "
                + repayment_month);
        }
    }

    private void removeView(View view) {
        for (int a = 0; a < mortgageList.size(); a++) {
            if (mortgageList.get(a) == view) {
                mortgageList.remove(a);
            }
        }
        for (int a = 0; a < fullList.size(); a++) {
            if (fullList.get(a) == view) {
                fullList.remove(a);
            }
        }
    }
}
