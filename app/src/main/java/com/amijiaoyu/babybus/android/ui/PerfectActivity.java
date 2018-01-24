package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import java.util.ArrayList;

import butterknife.BindView;
import java.util.Collections;
import java.util.List;

/**
 * @author Dsh
 * @date 2018/1/16
 */

public class PerfectActivity extends RxActivity implements View.OnClickListener {
    @BindView(R.id.tv_toolbar) TextView tvToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.add_data_home) AppCompatImageView addDataHome;
    @BindView(R.id.recycleView_home) RecyclerView recycleViewHome;
    @BindView(R.id.add_data_car) AppCompatImageView addDataCar;
    @BindView(R.id.recycleView_car) RecyclerView recycleViewCar;
    @BindView(R.id.add_data_policy) AppCompatImageView addDataPolicy;
    @BindView(R.id.recycleView_policy) RecyclerView recycleViewPolicy;
    @BindView(R.id.select_one) AppCompatTextView select_one;
    @BindView(R.id.select_two) AppCompatTextView select_two;
    @BindView(R.id.select_three) AppCompatTextView select_three;
    @BindView(R.id.no_home) RelativeLayout noHome;
    @BindView(R.id.no_car) RelativeLayout noCar;
    @BindView(R.id.next) AppCompatButton next;
    private static final int LIST_SIZE = 0;

    private static final int PERFECT_1 = 1;
    private static final int PERFECT_2 = 2;
    private static final int PERFECT_3 = 3;

    private static final int PERFECT_HOME_MORTGAGE_TIME = 4;
    private static final int PERFECT_HOME_MORTGAGE_MONTH = 5;
    private static final int PERFECT_HOME_FULL_MONTH = 6;
    private static final int PERFECT_CAR_MORTGAGE_MONTH = 7;
    private static final String TAG = "测试日志";

    String[] strings_1 = new String[] { "测试数据1", "测试数据1", "测试数据1", "测试数据1", "测试数据1" };
    String[] strings_2 = new String[] { "测试数据2", "测试数据2", "测试数据2", "测试数据2", "测试数据2" };
    String[] strings_3 = new String[] { "测试数据3", "测试数据3", "测试数据3", "测试数据3", "测试数据3" };
    String[] strings_4 = new String[] { "房产持有时间", "房产持有时间", "房产持有时间", "房产持有时间", "房产持有时间" };
    String[] strings_5 = new String[] { "房产月供期数", "房产月供期数", "房产月供期数", "房产月供期数", "房产月供期数" };
    String[] strings_6 = new String[] { "全款房持有时间", "全款房持有时间", "全款房持有时间", "全款房持有时间", "全款房持有时间" };
    String[] strings_7 = new String[] { "按揭车月供期数", "按揭车月供期数", "按揭车月供期数", "按揭车月供期数", "按揭车月供期数" };
    private List<View> mortgageList_home;
    private List<View> fullList_home;
    private List<View> mortgageList_car;
    private List<View> fullList_car;
    private List<View> policyList;

    @Override protected int getLayout() {
        return R.layout.activity_perfect;
    }

    @Override protected void initInject() {

    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        initView();
    }

    private void initListener() {
        select_one.setOnClickListener(this);
        select_two.setOnClickListener(this);
        select_three.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void initView() {
        mortgageList_home = new ArrayList<>();
        fullList_home = new ArrayList<>();
        mortgageList_car = new ArrayList<>();
        fullList_car = new ArrayList<>();
        policyList = new ArrayList<>();
        initToolBar(toolbar, tvToolbar, getString(R.string.perfect));

        //房产
        FootAdapter homeAdapter = new FootAdapter(new ArrayList<>());
        recycleViewHome.setLayoutManager(new LinearLayoutManager(this));
        recycleViewHome.setNestedScrollingEnabled(false);
        recycleViewHome.setAdapter(homeAdapter);
        addDataHome.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_sheet_home_no, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_perfect_home, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_perfect_full, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                homeAdapter.addFooterView(mortgage);
                mortgageList_home.add(mortgage);
                noHome.setVisibility(View.GONE);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                homeAdapter.addFooterView(full);
                noHome.setVisibility(View.GONE);
                fullList_home.add(full);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.no_have).setOnClickListener(v1 -> {
                noHome.setVisibility(View.VISIBLE);
                homeAdapter.removeAllFooterView();
                sheetDialog.dismiss();
            });

            sheetDialog.show();

            mortgage.findViewById(R.id.delete).setOnClickListener(v1 -> {
                homeAdapter.removeFooterView(mortgage);
                removeHomeView(mortgage);
            });

            if (mortgage != null) {
                AppCompatTextView valuation = mortgage.findViewById(R.id.time);
                valuation.setOnClickListener(v1 -> onClick(valuation, PERFECT_HOME_MORTGAGE_TIME));

                AppCompatTextView repayment_month = mortgage.findViewById(R.id.repayment_month);
                repayment_month.setOnClickListener(
                    v1 -> onClick(repayment_month, PERFECT_HOME_MORTGAGE_MONTH));
            }

            full.findViewById(R.id.delete).setOnClickListener(v1 -> {
                homeAdapter.removeFooterView(full);
                removeHomeView(full);
            });

            if (full != null) {
                AppCompatTextView valuation = full.findViewById(R.id.time);
                valuation.setOnClickListener(v1 -> onClick(valuation, PERFECT_HOME_FULL_MONTH));
            }
        });

        //车子
        FootAdapter carAdapter = new FootAdapter(new ArrayList<>());
        recycleViewCar.setLayoutManager(new LinearLayoutManager(this));
        recycleViewCar.setNestedScrollingEnabled(false);
        recycleViewCar.setAdapter(carAdapter);
        addDataCar.setOnClickListener(v -> {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
            @SuppressLint("InflateParams") View view =
                getLayoutInflater().inflate(R.layout.dialog_car_sheet_no, null);
            @SuppressLint("InflateParams") View mortgage =
                getLayoutInflater().inflate(R.layout.item_car, null);
            @SuppressLint("InflateParams") View full =
                getLayoutInflater().inflate(R.layout.item_full_car, null);
            sheetDialog.setContentView(view);
            view.findViewById(R.id.mortgage_home).setOnClickListener(v1 -> {
                carAdapter.addFooterView(mortgage);
                noCar.setVisibility(View.GONE);
                mortgageList_car.add(mortgage);
                sheetDialog.dismiss();
            });

            view.findViewById(R.id.full_home).setOnClickListener(v1 -> {
                carAdapter.addFooterView(full);
                noCar.setVisibility(View.GONE);
                fullList_car.add(full);
                sheetDialog.dismiss();
            });
            view.findViewById(R.id.no_have).setOnClickListener(v1 -> {
                noCar.setVisibility(View.VISIBLE);
                carAdapter.removeAllFooterView();
                sheetDialog.dismiss();
            });
            sheetDialog.show();

            mortgage.findViewById(R.id.delete).setOnClickListener(v1 -> {
                carAdapter.removeFooterView(mortgage);
                removeCarView(mortgage);
            });

            if (mortgage != null) {
                AppCompatTextView valuation = mortgage.findViewById(R.id.time);
                valuation.setOnClickListener(v1 -> onClick(valuation, PERFECT_CAR_MORTGAGE_MONTH));
            }

            if (full.findViewById(R.id.delete) != null) {
                full.findViewById(R.id.delete).setOnClickListener(v1 -> {
                    carAdapter.removeFooterView(full);
                    removeCarView(full);
                });
            }
        });

        //保单
        FootAdapter policyAdapter = new FootAdapter(new ArrayList<>());
        recycleViewPolicy.setLayoutManager(new LinearLayoutManager(this));
        recycleViewPolicy.setNestedScrollingEnabled(false);
        recycleViewPolicy.setAdapter(policyAdapter);
        addDataPolicy.setOnClickListener(v -> {
            @SuppressLint("InflateParams") View policyView =
                getLayoutInflater().inflate(R.layout.item_policy, null);
            policyAdapter.addFooterView(policyView);
            policyList.add(policyView);

            policyView.findViewById(R.id.delete).setOnClickListener(v1 -> {
                policyAdapter.removeFooterView(policyView);
                removePolicyView(policyView);
            });
        });
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_one:
                onClick(select_one, PERFECT_1);
                break;
            case R.id.select_two:
                onClick(select_two, PERFECT_2);
                break;
            case R.id.select_three:
                onClick(select_three, PERFECT_3);
                break;
            case R.id.next:
                getFinalData();
                break;
            default:
        }
    }

    public void onClick(AppCompatTextView v, int type) {
        switch (type) {
            case PERFECT_1:
                showSelectItem(initData(strings_1), v);
                break;
            case PERFECT_2:
                showSelectItem(initData(strings_2), v);
                break;
            case PERFECT_3:
                showSelectItem(initData(strings_3), v);
                break;
            case PERFECT_HOME_MORTGAGE_TIME:
                showSelectItem(initData(strings_4), v);
                break;
            case PERFECT_HOME_MORTGAGE_MONTH:
                showSelectItem(initData(strings_5), v);
                break;
            case PERFECT_HOME_FULL_MONTH:
                showSelectItem(initData(strings_6), v);
                break;
            case PERFECT_CAR_MORTGAGE_MONTH:
                showSelectItem(initData(strings_7), v);
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

    private void removeHomeView(View view) {
        for (int a = 0; a < mortgageList_home.size(); a++) {
            if (mortgageList_home.get(a) == view) {
                mortgageList_home.remove(a);
            }
        }
        for (int a = 0; a < fullList_home.size(); a++) {
            if (fullList_home.get(a) == view) {
                fullList_home.remove(a);
            }
        }
    }

    private void removeCarView(View view) {
        for (int a = 0; a < mortgageList_car.size(); a++) {
            if (mortgageList_car.get(a) == view) {
                mortgageList_car.remove(a);
            }
        }
        for (int a = 0; a < fullList_car.size(); a++) {
            if (fullList_car.get(a) == view) {
                fullList_car.remove(a);
            }
        }
    }

    private void removePolicyView(View view) {
        for (int a = 0; a < policyList.size(); a++) {
            if (policyList.get(a) == view) {
                policyList.remove(a);
            }
        }
    }

    private void getFinalData() {
        //房产的最终数据
        for (int a = 0; a < fullList_home.size(); a++) {
            String valuation =
                ((AppCompatTextView) fullList_home.get(a).findViewById(R.id.valuation)).getText()
                    .toString();
            String time =
                ((AppCompatTextView) fullList_home.get(a).findViewById(R.id.time)).getText()
                    .toString();
            Log.v(TAG, "全款房 " + valuation + "  " + time);
        }
        for (int a = 0; a < mortgageList_home.size(); a++) {
            String valuation = ((AppCompatTextView) mortgageList_home.get(a)
                .findViewById(R.id.valuation)).getText().toString();
            String balance =
                ((AppCompatEditText) mortgageList_home.get(a).findViewById(R.id.balance)).getText()
                    .toString();
            String time =
                ((AppCompatTextView) mortgageList_home.get(a).findViewById(R.id.time)).getText()
                    .toString();
            String month_money = ((AppCompatEditText) mortgageList_home.get(a)
                .findViewById(R.id.month_money)).getText().toString();
            String repayment_month = ((AppCompatTextView) mortgageList_home.get(a)
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

        //汽车的最终数据
        for (int a = 0; a < fullList_car.size(); a++) {
            String valuation =
                ((AppCompatTextView) fullList_car.get(a).findViewById(R.id.valuation)).getText()
                    .toString();
            Log.v(TAG, "全款车 " + valuation);
        }
        for (int a = 0; a < mortgageList_car.size(); a++) {
            String valuation =
                ((AppCompatTextView) mortgageList_car.get(a).findViewById(R.id.valuation)).getText()
                    .toString();
            String balance =
                ((AppCompatEditText) mortgageList_car.get(a).findViewById(R.id.balance)).getText()
                    .toString();
            String time =
                ((AppCompatTextView) mortgageList_car.get(a).findViewById(R.id.time)).getText()
                    .toString();
            String month_money = ((AppCompatEditText) mortgageList_car.get(a)
                .findViewById(R.id.month_money)).getText().toString();
            Log.v(TAG, "按揭车 " + valuation + "  " + time + "  " + balance + "  " + month_money);
        }

        //保单的最终数据
        for (int a = 0; a < policyList.size(); a++) {
            String balance =
                ((AppCompatTextView) policyList.get(a).findViewById(R.id.balance)).getText()
                    .toString();
            Log.v(TAG, "保单 " + balance);
        }
    }
}