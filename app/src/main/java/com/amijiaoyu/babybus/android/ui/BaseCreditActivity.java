package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.ui.BaseQualificationsActivity;
import com.amijiaoyu.babybus.android.ui.weight.ProLinearly;

import butterknife.BindView;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class BaseCreditActivity extends RxActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView title;


    @BindView(R.id.overdue)
    ProLinearly overdue;
    @BindView(R.id.credit)
    ProLinearly credit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.base_need));
        credit.setContentClickListener(v -> {

        });

        overdue.setContentClickListener(v -> {

        });

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_credit_info;
    }

    @Override
    protected void initInject() {

    }


}
