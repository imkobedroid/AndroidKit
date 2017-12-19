package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.amijiaoyu.babybus.android.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author moerlong
 */
public class MyView extends View {
    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    private Rect mBound;
    private Paint mPaint;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    /**
     * 利用构造函数把资源文件导入进来
     *
     * @param context      上下文对象
     * @param attrs        资源文件
     * @param defStyleAttr 默认的资源文件
     */
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int count = typedArray.getIndexCount();
        for (int a = 0; a < count; a++) {
            int attr = typedArray.getIndex(a);
            switch (attr) {
                case R.styleable.CustomTitleView_title:
                    mTitleText = typedArray.getString(attr);
                    break;

                case R.styleable.CustomTitleView_color:
                    mTitleTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;

                case R.styleable.CustomTitleView_size:
                    mTitleTextSize = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16,
                                    getResources().getDisplayMetrics()));
                    break;
                default:
            }
        }
        typedArray.recycle();

        this.setOnClickListener(v -> {
            mTitleText = randomText();
            postInvalidate();
        });
    }


    /**
     * 开始绘制整个view的样子
     *
     * @param canvas 传入的是一个画布的对象
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2,
                getHeight() / 2 + mBound.height() / 2, mPaint);
    }


    /**
     * 计算整个自定义view的组件有多大
     *
     * @param widthMeasureSpec  宽度的模式
     * @param heightMeasureSpec 高度的模式
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        mBound = new Rect();
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setAntiAlias(true);
        mPaint.setShadowLayer(2, 2, 2, Color.BLACK);
        //得到这个mBound的的大小 方便后面计算整个组件的大小
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);


        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = getPaddingLeft() + mBound.width() + getPaddingRight();

        }


        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {

            height = getPaddingBottom() + mBound.height() + getPaddingTop();
        }


        setMeasuredDimension(width, height);
    }

    private String randomText()
    {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        int anInt = 4;
        while (set.size() < anInt)
        {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : set)
        {
            sb.append("").append(i);
        }

        return sb.toString();
    }

}
