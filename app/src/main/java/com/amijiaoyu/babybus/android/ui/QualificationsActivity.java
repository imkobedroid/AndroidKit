package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import butterknife.BindView;

/**
 * @author moerlong
 * @date 2018/1/16
 */

@SuppressLint("Registered")
public class QualificationsActivity extends RxActivity {
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.property)
    AppCompatTextView property;

    @BindView(R.id.car)
    AppCompatTextView car;

    @Override
    protected int getLayout() {
        return R.layout.activity_qualification;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar, tvToolbar, getString(R.string.match));
        property.setOnClickListener(v -> startActivity(new Intent(this, QualificationsHomeActivity.class)));
        car.setOnClickListener(v -> startActivity(new Intent(this, QualificationsCarActivity.class)));
    }
}
