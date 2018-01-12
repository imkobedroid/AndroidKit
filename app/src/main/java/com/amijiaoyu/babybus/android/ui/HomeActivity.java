package com.amijiaoyu.babybus.android.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

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
    @BindView(R.id.myChatView)
    PieChart mChart;
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
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setCenterText(new SpannableString("80%\n月利率"));
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);
        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);
        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);
        mChart.setDrawCenterText(true);
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);
        setData(defaultData.length, defaultData);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mChart.getLegend().setEnabled(false);

    }


    @Override
    protected int getLayout() {
        return R.layout.item_money;
    }

    @Override
    protected void initInject() {
    }



    private void setData(int count,Float[] defaultData ) {

        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry(defaultData[i]));
        }
        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);
        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }

        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setAutomaticallyDisableSliceSpacing(false);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
        mChart.highlightValues(null);
        for (IDataSet<?> set : mChart.getData().getDataSets()) {
            set.setDrawValues(!set.isDrawValuesEnabled());
        }
        mChart.invalidate();
    }

}
