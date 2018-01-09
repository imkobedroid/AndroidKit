package com.amijiaoyu.babybus.android.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;



/**
 * @author Dsh
 */
public class CircularStatisticsView extends View {

    //-------------必须给的数据相关-------------

    /**
     *  分配比例大小，总比例大小为100,由于经过运算后最后会是99.55左右的数值，导致圆不能够重合，会留出点空白，所以这里的总比例大小我们用101
     */
    private int[] strPercent;
    /**
     * 圆的直径
     */
    private float mRadius = 200;
    /**
     * 圆的粗细
     */
    private float mStrokeWidth = 60;

    private Paint cyclePaint;

    private Paint labelPaint;

    /**
     * 边框颜色和标注颜色
     */
    private int[] mColor = new int[]{0xFF4FC3F7, 0xFF9575CD, 0xFFE57373};

    /**
     * View自身的宽和高
     */
    private int mHeight;
    private int mWidth;


    public CircularStatisticsView(Context context) {
        super(context);
    }

    public CircularStatisticsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularStatisticsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动画布到圆环的左上角
        canvas.translate(mWidth / 2 - mRadius / 2, mHeight / 2 - mRadius / 2);
        //初始化画笔
        initPaint();
        //画圆环
        drawCycle(canvas);

    }

    public void setSrc(int[] strPercent) {
        this.strPercent=strPercent;
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //边框画笔
        cyclePaint = new Paint();
        cyclePaint.setAntiAlias(true);
        cyclePaint.setStyle(Paint.Style.STROKE);
        cyclePaint.setStrokeWidth(mStrokeWidth);

        //标注画笔
        labelPaint = new Paint();
        labelPaint.setAntiAlias(true);
        labelPaint.setStyle(Paint.Style.FILL);
        labelPaint.setStrokeWidth(2);
    }

    /**
     * 画圆环
     *
     * @param canvas  画布
     */
    private void drawCycle(Canvas canvas) {
        float startPercent = 0;
        float sweepPercent = 0;
        for (int i = 0; i < strPercent.length; i++) {
            cyclePaint.setColor(mColor[i]);
            startPercent = sweepPercent + startPercent;
            //这里采用比例占100的百分比乘于360的来计算出占用的角度，使用先乘再除可以算出值
            sweepPercent = strPercent[i] * 360 / 100;
            canvas.drawArc(new RectF(0, 0, mRadius, mRadius), startPercent, sweepPercent, false, cyclePaint);
        }
    }

}