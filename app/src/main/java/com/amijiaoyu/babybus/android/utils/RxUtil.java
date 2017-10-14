package com.amijiaoyu.babybus.android.utils;

import com.amijiaoyu.babybus.android.model.bean.BaseBean;
import com.amijiaoyu.babybus.android.model.rx.BaseException;
import com.amijiaoyu.babybus.android.model.rx.RxTransformerException;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;

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
    return new FlowableTransformer<T, T>() {
      @Override public Flowable<T> apply(Flowable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  /**
   * 统一返回结果处理
   * @param <T>
   * @return
   */
    public static <T> FlowableTransformer<BaseBean<T>, T> handleResult() {
        return new FlowableTransformer<BaseBean<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<BaseBean<T>> httpResponse) {
                return httpResponse.flatMap(new Function<BaseBean<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(BaseBean<T> tMyHttpResponse) {
                        if(tMyHttpResponse.getCode() == 0) {
                            return createData(tMyHttpResponse.getData());
                        } else {
                            return Flowable.error(new RxTransformerException(BaseException.ERROR_TRANSFORMER,""));
                        }
                    }
                });
            }
        };
    }

  /**
   * 重新生成Flowable数据
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
}
