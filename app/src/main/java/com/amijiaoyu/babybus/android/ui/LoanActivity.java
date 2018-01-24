package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.weight.ActionItem;
import com.amijiaoyu.babybus.android.weight.TitlePopup;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author moerlong
 */

@SuppressLint("Registered") public class LoanActivity extends RxActivity
    implements TitlePopup.OnItemOnClickListener {
    @BindView(R.id.recycleView) RecyclerView recycleView;
    @BindView(R.id.total) AppCompatTextView total;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tv_toolbar) TextView title;
    @BindView(R.id.tv_toolbar_right) TextView right;
    private static final int ITEM_POSITION_ONE = 0;
    private static final int ITEM_POSITION_TWO = 1;
    private static final int ITEM_POSITION_THREE = 2;
    private static final int ITEM_POSITION_FOUR = 3;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.match));
        right.setText(R.string.more);
        initRecycleView();
    }

    private void initRecycleView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<LoginBean> loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        LoanAdapter loanAdapter = new LoanAdapter(loginBeans);
        loanAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        loanAdapter.addHeaderView(getLayoutInflater().inflate(R.layout.head_loan, null));
        recycleView.setAdapter(loanAdapter);

        right.setOnClickListener(v -> {
            TitlePopup titlePopup = new TitlePopup(this, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, this);
            titlePopup.addAction(new ActionItem(this, "编辑需求", R.mipmap.loan_demand));
            titlePopup.addAction(new ActionItem(this, "编辑资质", R.mipmap.loan_aptitude));
            titlePopup.addAction(new ActionItem(this, "购物车(12)", R.mipmap.loan_shopping));
            titlePopup.addAction(new ActionItem(this, "黑名单(12)", R.mipmap.loan_blacklis));
            titlePopup.show(v);
        });
    }

    @Override protected int getLayout() {
        return R.layout.activity_loan;
    }

    @Override protected void initInject() {

    }

    @Override public void onItemClick(ActionItem item, int position) {
        switch (position) {
            case ITEM_POSITION_ONE:
                //编辑需求
                break;
            case ITEM_POSITION_TWO:
                //编辑资质
                break;
            case ITEM_POSITION_THREE:
                //购物车
                break;
            case ITEM_POSITION_FOUR:
                //黑名单
                startActivity(new Intent(this,BlackActivity.class));
                break;
            default:
        }
    }
}
