package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;

import com.amijiaoyu.babybus.android.R;
import com.kaopiz.kprogresshud.KProgressHUD;

/**
 *
 * @author Dsh
 * @date 2017/5/8
 * Use:
 */
public class ProgressDialogHandler extends Handler {

  public static final int SHOW_PROGRESS_DIALOG = 1;
  public static final int DISMISS_PROGRESS_DIALOG = 0;

  private KProgressHUD mProgressDialog;

  private Context context;
  private boolean cancelable;
  private OnProgressCancelListener mProgressCancelListener;

  public ProgressDialogHandler(Context context) {
    this(context, false, null);
  }

  public ProgressDialogHandler(Context context, boolean cancelable,
      OnProgressCancelListener progressCancelListener) {
    super();
    this.context = context;
    this.mProgressCancelListener = progressCancelListener;
    this.cancelable = cancelable;
    initProgressDialog();
  }

  private void initProgressDialog() {
    if (mProgressDialog == null) {
        mProgressDialog=KProgressHUD.create(context)
            .setLabel("loading...")
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setBackgroundColor(ContextCompat.getColor(context,R.color.default_gray))
            .setAnimationSpeed(2);

      if (cancelable) {
          // TODO: 2018/3/19 点击取消请求后的监听操作
         /* if (mProgressCancelListener != null) {
              mProgressCancelListener.onCancelProgress();
          }*/

      }
    }
  }

  public void showProgressDialog() {
    if (mProgressDialog != null && !mProgressDialog.isShowing()) {
      mProgressDialog.show();
    }
  }

  public void dismissProgressDialog() {
    if (mProgressDialog != null) {
      mProgressDialog.dismiss();
      mProgressDialog = null;
    }
  }

  @Override public void handleMessage(Message msg) {
    if (msg.what == SHOW_PROGRESS_DIALOG) {
      showProgressDialog();
    } else if (msg.what == DISMISS_PROGRESS_DIALOG) {
      dismissProgressDialog();
    }
  }


  public interface OnProgressCancelListener {
    /**
     * 自定义的对话框取消的监听
     */
    void onCancelProgress();
  }
}