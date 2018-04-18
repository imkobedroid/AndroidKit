package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.ui.weight.ProLinearly;

import butterknife.BindView;
import ch.ielse.view.SwitchView;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class AddInfoActivity extends RxActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView title;

    @BindView(R.id.select_full_house)
    SwitchView switchView;

    @BindView(R.id.full_house)
    LinearLayout fullHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.base_need));
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                fullHouse.setVisibility(View.VISIBLE);
                switchView.setOpened(true);
            }

            @Override
            public void toggleToOff(SwitchView view) {
                fullHouse.setVisibility(View.GONE);
                switchView.setOpened(false);

            }
        });

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_qualifications_info;
    }

    @Override
    protected void initInject() {
    }


}
