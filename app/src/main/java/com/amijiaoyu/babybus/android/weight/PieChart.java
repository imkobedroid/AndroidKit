package com.amijiaoyu.babybus.android.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;

/**
 * @author Dsh
 */
public class PieChart extends View {
    private float[] item;
    private float total;
    private String[] colors;
    private float[] itemsAngle;
    private float[] itemsBeginAngle;
    private float[] itemsrate;
    private float radius = 150;
    private DecimalFormat fnum;
    private OnItemClickListener listener;
    private int downX, downY, tempX, tempY;
    private static final String[] DEFAULT_ITEMS_COLORS = {"#ff80FF",
        "#ffFF00", "#6A5ACD", "#20B2AA", "#00BFFF", "#CD5C5C", "#8B658B",
        "#CD853F", "#006400", "#FF4500", "#D8BFD8", "#4876FF", "#FF00FF",
        "#FF83FA", "#0000FF", "#363636", "#FFDAB9", "#90EE90", "#8B008B",
        "#00BFFF", "#00FF00", "#006400", "#00FFFF", "#668B8B", "#000080",
        "#008B8B"};

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        fnum = new DecimalFormat("##0.00");
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }


    public void setItem(float[] item) {
        this.item = item;
        if (item != null && item.length > 0) {
            jsTotal();
            refreshItemsAngs();
            colors = DEFAULT_ITEMS_COLORS;
        }
    }

    /**
     * 带有点击事件的
     * @param item   比例值
     * @param colors  颜色
     * @param listener  点击监听
     */
    public void initSrc(float[] item, String[] colors, OnItemClickListener listener) {
        setItem(item);
        setColors(colors);
        notifyDraw();
        this.listener = listener;
    }

    /**
     * 不带有点击事件的
     * @param item   比例
     * @param colors  颜色
     */
    public void initSrc(float[] item, String[] colors) {
        setItem(item);
        setColors(colors);
        notifyDraw();
    }

    public void setColors(String[] colors) {
        if (colors != null && colors.length > 0) {
            this.colors = colors;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float letftop = 0;
        float rightbottom = 2 * radius;
        float centerXY = radius;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (item == null || item.length == 0) {
            paint.setTextSize(radius / 4);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.parseColor("#000000"));
            FontMetrics fontMetrics = paint.getFontMetrics();
            float fontTotalHeight = fontMetrics.bottom - fontMetrics.top;
            float offY = fontTotalHeight / 2 - fontMetrics.bottom;
            float newY = centerXY + offY;
            canvas.drawText("����", centerXY, newY, paint);
        } else {
            @SuppressLint("DrawAllocation") RectF oval = new RectF(letftop, letftop, rightbottom, rightbottom);
            for (int i = 0; i < item.length; i++) {
                paint.setColor(Color.parseColor(colors[i]));
                canvas.drawArc(oval, itemsBeginAngle[i], itemsAngle[i], true,
                    paint);
            }

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#ffffff"));
            //内圆的半径设置
            canvas.drawCircle(centerXY, centerXY, radius / 1.5f, paint);
            //文字的大小
            paint.setTextSize(radius / 4);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.parseColor("#000000"));
            FontMetrics fontMetrics = paint.getFontMetrics();
            float fontTotalHeight = fontMetrics.bottom - fontMetrics.top;
            float offY = fontTotalHeight / 2 - fontMetrics.bottom;
            float newY = centerXY + offY;
            //  设置文字的地方
            canvas.drawText("", centerXY, newY, paint);
        }
    }


    private void jsTotal() {
        total = 0;
        for (float i : item) {
            total += i;
        }
    }


    private void refreshItemsAngs() {
        if (item != null && item.length > 0) {
            itemsrate = new float[item.length];
            itemsBeginAngle = new float[item.length];
            itemsAngle = new float[item.length];
            //第一次开始绘制的角度
            float beginAngle = -0.25f;
            for (int i = 0; i < item.length; i++) {
                itemsrate[i] = (float) (item[i] * 1.0 / total * 1.0);
            }
            for (int i = 0; i < itemsrate.length; i++) {
                if (i == 1) {
                    beginAngle = 360 * itemsrate[i - 1];
                } else if (i > 1) {
                    beginAngle = 360 * itemsrate[i - 1] + beginAngle;
                }
                itemsBeginAngle[i] = beginAngle - 90;
                itemsAngle[i] = 360 * itemsrate[i];
            }

        }

    }


    public void notifyDraw() {
        invalidate();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float widthHeight = 2 * (radius);
        setMeasuredDimension((int) widthHeight, (int) widthHeight);
    }


    public interface OnItemClickListener {
        void click(int position);
    }
}
