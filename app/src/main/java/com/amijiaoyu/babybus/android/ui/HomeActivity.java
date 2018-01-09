package com.amijiaoyu.babybus.android.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.weight.CircularStatisticsView;

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
    @BindView(R.id.percentage)
    AppCompatTextView percentage;
    @BindView(R.id.image_graphical)
    RelativeLayout imageGraphical;
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
    @BindView(R.id.myChatView)
    CircularStatisticsView myChatView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        textName.setText("贷款一号");
        nameContent.setText("就地方开始减肥看电视就");
        percentage.setText("80%");
        textMoney.setText("18");
        textTime.setText("18");
        textRepayment.setText("18");

        contentOne.setText("应该还发生的发生");
        contentThree.setText("应该还发生的发生");
        contentTwo.setText("应该还发生的发生");
        int[] strPercent = new int[]{10,50,40};
        myChatView.setSrc(strPercent);
    }


    @Override
    protected int getLayout() {
        return R.layout.item_money;
    }

    @Override
    protected void initInject() {
    }


}
