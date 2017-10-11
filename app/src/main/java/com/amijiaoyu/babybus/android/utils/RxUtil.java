package com.amijiaoyu.babybus.android.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;

/**
 * @author keal
 *         Created  on 2017/05/03 15:40.
 *         Summary:
 */
public class RxUtil {


  public static Bitmap addTextWatermark(Bitmap src, String text, float textSize, int color, float x, float y) {
    if (src == null || text == null) return null;
    Bitmap bitmap = src.copy(src.getConfig(), true);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Canvas canvas = new Canvas(bitmap);
    paint.setColor(color);
    paint.setTextSize(textSize);
    Rect bounds = new Rect();
    paint.getTextBounds(text, 0, text.length(), bounds);
    canvas.drawText(text, x, y + textSize, paint);
    src.recycle();
    return bitmap;
  }


  //添加图片水印
  public static Bitmap createBitmapForWatermark(Bitmap src, Bitmap watermark) {
    if (src == null) {
      return null;
    }
    int w = src.getWidth();
    int h = src.getHeight();
    int ww = watermark.getWidth();
    int wh = watermark.getHeight();
    // create the new blank bitmap
    Bitmap newb = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);// 创建一个新的和SRC长度宽度一样的位图
    Canvas cv = new Canvas(newb);
    // draw src into
    cv.drawBitmap(src, 0, 0, null);// 在 0，0坐标开始画入src
    // draw watermark into
    cv.drawBitmap(watermark, w - ww + 5, h - wh + 5, null);// 在src的右下角画入水印
    // save all clip
    cv.save(Canvas.ALL_SAVE_FLAG);// 保存
    // store
    cv.restore();// 存储
    return newb;
  }



  /**
   * 获取保留两位的数据
   */
  // TODO: 16/9/9 四舍五入
  public static String getDoubleDecimal(double d) {
    return String.format(Locale.CHINA, "%.2f", d);
  }

  //RxUtil.getDoubleDecimal(data.getCapacity_max() / 100F)

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
/*    public static <T> FlowableTransformer<GankHttpResponse<T>, T> handleResult() {   //compose判断结果
        return new FlowableTransformer<GankHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<GankHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<GankHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GankHttpResponse<T> tGankHttpResponse) {
                        if(!tGankHttpResponse.getError()) {
                            return createData(tGankHttpResponse.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }*/

  /**
   * 统一返回结果处理
   * @param <T>
   * @return
   */
   /* public static <T> FlowableTransformer<WXHttpResponse<T>, T> handleWXResult() {   //compose判断结果
        return new FlowableTransformer<WXHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<WXHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<WXHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(WXHttpResponse<T> tWXHttpResponse) {
                        if(tWXHttpResponse.getCode() == 200) {
                            return createData(tWXHttpResponse.getNewslist());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }*/

  /**
   * 统一返回结果处理
   * @param <T>
   * @return
   */
  /*  public static <T> FlowableTransformer<MyHttpResponse<T>, T> handleMyResult() {   //compose判断结果
        return new FlowableTransformer<MyHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<MyHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<MyHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(MyHttpResponse<T> tMyHttpResponse) {
                        if(tMyHttpResponse.getCode() == 200) {
                            return createData(tMyHttpResponse.getData());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }*/

  /**
   * 统一返回结果处理
   * @param <T>
   * @return
   */
    /*public static <T> FlowableTransformer<GoldHttpResponse<T>, T> handleGoldResult() {   //compose判断结果
        return new FlowableTransformer<GoldHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<GoldHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<GoldHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GoldHttpResponse<T> tGoldHttpResponse) {
                        if(tGoldHttpResponse.getResults() != null) {
                            return createData(tGoldHttpResponse.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }*/

  /**
   * 生成Flowable
   */
  public static <T> Flowable<T> createData(final T t) {
    return Flowable.create(new FlowableOnSubscribe<T>() {
      @Override public void subscribe(FlowableEmitter<T> emitter) throws Exception {
        try {
          emitter.onNext(t);
          emitter.onComplete();
        } catch (Exception e) {
          emitter.onError(e);
        }
      }
    }, BackpressureStrategy.BUFFER);
  }
}
