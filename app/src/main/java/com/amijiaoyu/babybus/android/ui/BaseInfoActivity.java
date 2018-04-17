package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.ui.weight.ProLinearly;

import butterknife.BindView;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class BaseInfoActivity extends RxActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView title;
    @BindView(R.id.into)
    ProLinearly into;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.base_need));


    }


    @Override
    protected int getLayout() {
        return R.layout.activity_base_info;
    }

    @Override
    protected void initInject() {
        into.setRootClickListener(v -> startActivity(new Intent(this,BaseQualificationsActivity.class)));
    }


}
