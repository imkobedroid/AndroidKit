package com.amijiaoyu.babybus.android.ui.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.amijiaoyu.babybus.android.R;

/**
 * @author Dsh  on 2018/4/17.
 */

public class ProLinearly extends RelativeLayout {


    private String titleText;
    private int titleSize;
    private int titleColor;

    private int lineColor;
    private int rootBacColor;
    private int contextColor;
    private String contextText;
    private int contextSize;
    private int editHintColor;

    private int lineLeftPadding;
    private int lineRightPadding;

    private boolean contextHide = true;
    private boolean iconHide = true;
    private boolean editHide = true;
    private boolean wanHide = true;
    private String editHint;
    public RootClickListener rootClickListener;
    public ContentClickListener contentClickListener;


    public ProLinearly(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View myView = LayoutInflater.from(context).inflate(R.layout.layout_custom, this, true);
        RelativeLayout root = myView.findViewById(R.id.root);
        AppCompatTextView title = myView.findViewById(R.id.title);
        AppCompatTextView content = myView.findViewById(R.id.content);


        AppCompatImageView icon = myView.findViewById(R.id.icon);
        AppCompatTextView wan = myView.findViewById(R.id.icon_text);
        AppCompatEditText edit = myView.findViewById(R.id.content_edit);


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
                    contextHide = a.getBoolean(index, true);
                    break;
                case R.styleable.ProLinearly_editHide:
                    editHide = a.getBoolean(index, true);
                    break;
                case R.styleable.ProLinearly_iconHide:
                    iconHide = a.getBoolean(index, true);
                    break;
                case R.styleable.ProLinearly_wanHide:
                    wanHide = a.getBoolean(index, true);
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

                case R.styleable.ProLinearly_editHintColor:
                    editHintColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_black));
                    break;

                case R.styleable.ProLinearly_contextText:
                    contextText = a.getString(index);
                    break;
                case R.styleable.ProLinearly_editHint:
                    editHint = a.getString(index);
                    break;
                case R.styleable.ProLinearly_contextColor:
                    contextColor = a.getColor(index, ContextCompat.getColor(context, R.color.default_white));
                    break;
                case R.styleable.ProLinearly_contextSize:
                    contextSize = a.getDimensionPixelSize(index, 14);
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


        icon.setVisibility(iconHide ? INVISIBLE : VISIBLE);
        wan.setVisibility(wanHide ? INVISIBLE : VISIBLE);
        content.setVisibility(contextHide ? INVISIBLE : VISIBLE);
        edit.setVisibility(editHide ? INVISIBLE : VISIBLE);
        edit.setHint(editHint);
        edit.setTextColor(editHintColor);

        //背景颜色
        root.setBackgroundColor(rootBacColor);

        //设置title的样式
        title.setTextColor(titleColor);
        title.setTextSize(titleSize);
        title.setText(titleText);

        //iconTitle样式
        content.setText(contextText);
        content.setTextSize(contextSize);
        content.setTextColor(contextColor);
        content.setVisibility(contextHide ? GONE : VISIBLE);

        //Line的样式
        line.setBackgroundColor(lineColor);
        //注意这里要用view的属性，因为viewGroup中没有leftMargin的属性设置方法
        LayoutParams layoutParams = (LayoutParams) line.getLayoutParams();
        layoutParams.leftMargin = lineLeftPadding;
        layoutParams.rightMargin = lineRightPadding;
        line.setLayoutParams(layoutParams);
        root.setOnClickListener(v -> {
            if (rootClickListener != null) {
                rootClickListener.click(content);
            }
        });

        content.setOnClickListener(v -> {
            if (contentClickListener!=null){
                contentClickListener.click(v);
            }
        });
    }

    public void setRootClickListener(RootClickListener rootClickListener) {
        this.rootClickListener = rootClickListener;
    }

    public void setContentClickListener(ContentClickListener contentClickListener) {
        this.contentClickListener = contentClickListener;
    }


    public interface RootClickListener {
        /**
         * 父布局的点击事件
         *
         * @param v 组件
         */
        void click(View v);
    }

    public interface ContentClickListener {
        /**
         * content点击事件
         *
         * @param v 组件
         */
        void click(View v);
    }
}