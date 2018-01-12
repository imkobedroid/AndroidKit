package com.amijiaoyu.babybus.android.utils;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import com.amijiaoyu.babybus.android.model.rx.RxTransformerException;
import com.tapadoo.alerter.Alerter;

import java.util.List;
import java.util.Locale;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Dsh
 */
public class RxUtil {

    private static DisplayMetrics mMetrics;
    private static int mMinimumFlingVelocity = 50;
    private static int mMaximumFlingVelocity = 8000;
    public final static double DEG2RAD = (Math.PI / 180.0);
    public final static float FDEG2RAD = ((float) Math.PI / 180.f);

  /**
   * 获取保留两位的数据
   */
  public static String getDoubleDecimal(double d) {
    return String.format(Locale.CHINA, "%.2f", d);
  }


  /**
   * 统一线程处理
   */
  public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
    return observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  /**
   * 统一返回结果处理
   * @param <T>  类型未知
   * @return 返回一个被观察者
   */
    public static <T> FlowableTransformer<BaseBean<T>, T> handleResult() {
        return httpResponse -> httpResponse.flatMap((Function<BaseBean<T>, Flowable<T>>) tMyHttpResponse -> {
            if(tMyHttpResponse.getCode() == 0) {
                return createData(tMyHttpResponse.getData());
            } else {
                return Flowable.error(new RxTransformerException(tMyHttpResponse.getCode(),tMyHttpResponse.getMessage()));
            }
        });
    }

  /**
   * 重新生成被观察者
   */
  public static <T> Flowable<T> createData(final T t) {
    return Flowable.create(emitter -> {
      try {
        emitter.onNext(t);
        emitter.onComplete();
      } catch (Exception e) {
        emitter.onError(e);
      }
    }, BackpressureStrategy.BUFFER);
  }

  public  static  void showAlerterDialog(Activity context,String title,String Content){
    Alerter.create(context)
        .setTitle(title)
        .setDuration(1000)
        .setIcon(R.drawable.alerter_ic_face)
        .setBackgroundColorRes(R.color.colorAccent)
        .setText(Content)
        .show();
  }

    @SuppressWarnings("unused")
    public final static double DOUBLE_EPSILON = Double.longBitsToDouble(1);

    @SuppressWarnings("unused")
    public final static float FLOAT_EPSILON = Float.intBitsToFloat(1);

    public static float convertDpToPixel(float dp) {
        if (mMetrics == null) {
            return dp;
        }
        return dp * mMetrics.density;
    }

    public static int calcTextWidth(Paint paint, String demoText) {
        return (int) paint.measureText(demoText);
    }


    public static int calcTextHeight(Paint paint, String demoText) {

        Rect r = new Rect();
        r.set(0,0,0,0);
        paint.getTextBounds(demoText, 0, demoText.length(), r);
        return r.height();
    }

    public static int[] convertIntegers(List<Integer> integers) {

        int[] ret = new int[integers.size()];

        copyIntegers(integers, ret);

        return ret;
    }

    public static void copyIntegers(List<Integer> from, int[] to){
        int count = to.length < from.size() ? to.length : from.size();
        for(int i = 0 ; i < count ; i++){
            to[i] = from.get(i);
        }
    }

}


