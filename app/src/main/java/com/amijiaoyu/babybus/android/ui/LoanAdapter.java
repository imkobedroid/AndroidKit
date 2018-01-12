package com.amijiaoyu.babybus.android.ui;

import android.graphics.Color;
import android.text.SpannableString;

import com.amijiaoyu.babybus.android.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moerlong
 * @date 2018/1/12
 */

public class LoanAdapter extends BaseQuickAdapter<LoginBean, BaseViewHolder> {
    private final static Float[] DEFAULT_DATA = {10.6F, 50.4F, 39F};

    LoanAdapter(List data) {
        super(R.layout.item_money, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, LoginBean loginBean) {
        baseViewHolder.setText(R.id.text_name, "贷款一号");
        baseViewHolder.setText(R.id.name_content, "贷款一号");
        baseViewHolder.setText(R.id.text_money, "贷款一号");
        baseViewHolder.setText(R.id.text_time, "18");
        baseViewHolder.setText(R.id.text_repayment, "100");
        baseViewHolder.setText(R.id.content_one, "贷款一号");
        baseViewHolder.setText(R.id.content_two, "贷款一号");
        baseViewHolder.setText(R.id.content_three, "贷款一号");
        initChartView(baseViewHolder.getView(R.id.myChatView));
    }

    private void initChartView(PieChart mChart) {
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
        setData(DEFAULT_DATA.length, DEFAULT_DATA, mChart);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mChart.getLegend().setEnabled(false);
    }

    private void setData(int count, Float[] defaultData, PieChart mChart) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
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
