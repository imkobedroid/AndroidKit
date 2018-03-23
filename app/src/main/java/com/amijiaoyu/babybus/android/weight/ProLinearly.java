package com.amijiaoyu.babybus.android.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.amijiaoyu.babybus.android.R;

/**
 * @author Dsh  on 2018/3/23.
 */

public class ProLinearly extends RelativeLayout {


    private String titleText;
    private int titleSize;
    private int titleColor;
    private int lineColor;
    private int rootBacColor;
    private int iconColor;
    private String iconText;
    private int iconSize;
    private int lineLeftPadding;
    private int lineRightPadding;
    private boolean iconTextHide;


    public ProLinearly(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }


    private void initView(Context context, AttributeSet attrs) {
        View myView = LayoutInflater.from(context).inflate(R.layout.layout_custom, this, true);
        RelativeLayout root = myView.findViewById(R.id.root);
        AppCompatTextView title = myView.findViewById(R.id.title);
        AppCompatTextView iconTitle = myView.findViewById(R.id.icon_content);
        View line = myView.findViewById(R.id.line);
        TypedArray a = context.getTheme().
            obtainStyledAttributes(attrs, R.styleable.ProLinearly,
                0, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int index = a.getIndex(i);
            switch (index) {
                case R.styleable.ProLinearly_title:
                    titleText = a.getString(index);
                    break;
                case R.styleable.ProLinearly_iconTextHide:
                    iconTextHide = a.getBoolean(index, false);
                    break;
                case R.styleable.ProLinearly_titleColor:
                    titleColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_black));
                    break;
                case R.styleable.ProLinearly_titleSize:
                    titleSize = a.getDimensionPixelSize(index, 14);
                    break;
                case R.styleable.ProLinearly_lineColor:
                    lineColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_black));
                    break;
                case R.styleable.ProLinearly_rootBacColor:
                    rootBacColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_white));
                    break;
                case R.styleable.ProLinearly_iconText:
                    iconText = a.getString(index);
                    break;
                case R.styleable.ProLinearly_iconColor:
                    iconColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_white));
                    break;
                case R.styleable.ProLinearly_iconSize:
                    iconSize = a.getDimensionPixelSize(index, 14);
                    break;
                case R.styleable.ProLinearly_lineLeftPadding:
                    lineLeftPadding = a.getDimensionPixelSize(index, 0);
                    break;
                case R.styleable.ProLinearly_lineRightPadding:
                    lineRightPadding = a.getDimensionPixelSize(index, 0);
                    break;
                default:
            }
        }
        a.recycle();

        //背景颜色
        root.setBackgroundColor(rootBacColor);

        //设置title的样式
        title.setTextColor(titleColor);
        title.setTextSize(titleSize);
        title.setText(titleText);

        //iconTitle样式
        iconTitle.setText(iconText);
        iconTitle.setTextSize(iconSize);
        iconTitle.setTextColor(iconColor);
        iconTitle.setVisibility(iconTextHide ? GONE : VISIBLE);

        //Line的样式
        line.setBackgroundColor(lineColor);
        LayoutParams layoutParams = (LayoutParams) line.getLayoutParams();
        layoutParams.leftMargin=lineLeftPadding;
        layoutParams.rightMargin=lineRightPadding;
        line.setLayoutParams(layoutParams);
    }

}
