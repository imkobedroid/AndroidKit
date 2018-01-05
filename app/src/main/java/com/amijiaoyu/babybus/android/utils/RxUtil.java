package com.amijiaoyu.babybus.android.utils;

import android.app.Activity;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import com.amijiaoyu.babybus.android.model.rx.BaseException;
import com.amijiaoyu.babybus.android.model.rx.RxTransformerException;
import com.tapadoo.alerter.Alerter;

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
}
