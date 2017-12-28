package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.amijiaoyu.babybus.android.R;


/**
 * @author moerlong
 */
public class MyImageView extends View {
    private static final int IMAGE_SCALE_FITXY = 0;
    private Bitmap mImage;
    private int mImageScale;
    private String mTitle;
    private int mTextSize;
    private int mTextColor;
    private Rect rect;
    private Paint paint;
    private Rect mTextBound;
    private int width = 0;
    private int height = 0;

    public MyImageView(Context context) {
        this(context, null);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        for (int a = 0; a < typedArray.getIndexCount(); a++) {
            int attr = typedArray.getIndex(a);
            switch (attr) {
                case R.styleable.CustomTitleView_image:
                    mImage = BitmapFactory.decodeResource(getResources(), typedArray.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomTitleView_imageScaleType:
                    mImageScale = typedArray.getInt(attr, 0);
                    break;
                case R.styleable.CustomTitleView_title:
                    mTitle = typedArray.getString(attr);
                    break;
                case R.styleable.CustomTitleView_color:
                    mTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_size:
                    mTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            16, getResources().getDisplayMetrics()));
                    break;
                default:
            }
        }

        typedArray.recycle();
        rect = new Rect();
        paint = new Paint();
        mTextBound = new Rect();
        paint.setTextSize(mTextSize);
        paint.getTextBounds(mTitle, 0, mTitle.length(), mTextBound);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.CYAN);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);

        rect.left = getPaddingLeft();
        rect.top = getPaddingTop();
        rect.right = getMeasuredWidth() - getPaddingRight();
        rect.bottom = getMeasuredHeight() - getPaddingBottom();
        paint.setColor(mTextColor);
        paint.setStyle(Paint.Style.FILL);

        if (mTextBound.width() > width) {
            @SuppressLint("DrawAllocation") TextPaint textPaint = new TextPaint(paint);
            String msg = TextUtils.ellipsize(mTitle, textPaint, width - getPaddingLeft() - getPaddingRight(),
                    TextUtils.TruncateAt.END).toString();
            canvas.drawText(msg, getPaddingLeft(), height - getPaddingBottom(), paint);

        } else {
            //正常情况，将字体居中
            canvas.drawText(mTitle, width / 2 - mTextBound.width() * 1.0f / 2, height - getPaddingBottom(), paint);
        }

        //取消掉字体的高度绘制出一个矩形
        rect.bottom -= mTextBound.height();

        if (mImageScale == IMAGE_SCALE_FITXY) {
            canvas.drawBitmap(mImage, null, rect, paint);
        } else {
            //计算居中的矩形范围
            rect.left = width / 2 - mImage.getWidth() / 2;
            rect.right = width / 2 + mImage.getWidth() / 2;
            rect.top = (height - mTextBound.height()) / 2 - mImage.getHeight() / 2;
            rect.bottom = (height - mTextBound.height()) / 2 + mImage.getHeight() / 2;

            canvas.drawBitmap(mImage, null, rect, paint);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            int desireByImage = getPaddingRight() + getPaddingLeft() + mImage.getWidth();
            int desireByTitle = getPaddingLeft() + getPaddingRight() + mTextBound.width();
            if (widthMode == MeasureSpec.AT_MOST) {
                int desire = Math.max(desireByImage, desireByTitle);
                width = Math.min(desire, widthSize);
            }
        }


        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            int desireHeight = getPaddingTop() + getPaddingBottom() + mTextBound.height() + mImage.getHeight();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(desireHeight, heightSize);
            }
        }

        setMeasuredDimension(width, height);

    }
}
