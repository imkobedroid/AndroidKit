package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.weight.CircularStatisticsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Date:2017/10/16 14:00
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class HomeActivity extends RxActivity{
    @BindView(R.id.cs_view)CircularStatisticsView statisticsView;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
  }

    private void initView() {
        // 添加的是颜色
        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.alert_default_error_background);
        colorList.add(R.color.support_ui_blue);
        colorList.add(R.color.alerter_default_success_background);
        colorList.add(R.color.blue_btn_bg_color);

        //  添加的是百分比
        List<Float> rateList = new ArrayList<>();
        rateList.add(10f);
        rateList.add(5f);
        rateList.add(45f);
        rateList.add(40f);
        statisticsView.setShow(colorList, rateList,true,false);


    }


    @Override protected int getLayout() {
    return R.layout.activity_home;
  }

  @Override protected void initInject() {
  }


}
