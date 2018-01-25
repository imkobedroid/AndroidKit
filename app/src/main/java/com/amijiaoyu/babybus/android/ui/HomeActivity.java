package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Date:2017/10/16 14:00
 * Email:imkobedroid@gmail.com
 *
 * @author dongshihong
 */

public class HomeActivity extends RxActivity {
    @BindView(R.id.image_select)
    ImageView imageSelect;
    @BindView(R.id.image_head)
    CircleImageView imageHead;
    @BindView(R.id.text_name)
    AppCompatTextView textName;
    @BindView(R.id.name_content)
    AppCompatTextView nameContent;
    @BindView(R.id.root_top)
    RelativeLayout rootTop;
    @BindView(R.id.money)
    AppCompatTextView money;
    @BindView(R.id.time)
    AppCompatTextView time;
    @BindView(R.id.repayment)
    AppCompatTextView repayment;
    @BindView(R.id.text_money)
    AppCompatTextView textMoney;
    @BindView(R.id.text_time)
    AppCompatTextView textTime;
    @BindView(R.id.text_repayment)
    AppCompatTextView textRepayment;
    @BindView(R.id.root_center)
    RelativeLayout rootCenter;
    @BindView(R.id.blue)
    CircleImageView blue;
    @BindView(R.id.content_one)
    AppCompatTextView contentOne;
    @BindView(R.id.blue_one)
    CircleImageView blueOne;
    @BindView(R.id.content_two)
    AppCompatTextView contentTwo;
    @BindView(R.id.blue_two)
    CircleImageView blueTwo;
    @BindView(R.id.content_three)
    AppCompatTextView contentThree;

    private final static Float[] defaultData={10.6F,50.4F,39F};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        textName.setText("贷款一号");
        nameContent.setText("就地方开始减肥看电视就");

        textMoney.setText("18");
        textTime.setText("18");
        textRepayment.setText("18");

        contentOne.setText("应该还发生的发生");
        contentThree.setText("应该还发生的发生");
        contentTwo.setText("应该还发生的发生");

        initChartView();
    }

    private void initChartView() {


    }


    @Override
    protected int getLayout() {
        return R.layout.item_loan;
    }

    @Override
    protected void initInject() {
    }

}
