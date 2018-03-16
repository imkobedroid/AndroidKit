package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.amijiaoyu.babybus.android.R;

/**
 *
 * @author Dsh
 * @date 2017/5/8
 * Use:
 */
public class ProgressDialogHandler extends Handler {

  public static final int SHOW_PROGRESS_DIALOG = 1;
  public static final int DISMISS_PROGRESS_DIALOG = 0;

  private SweetAlertDialog mProgressDialog;

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
      mProgressDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
      mProgressDialog.getProgressHelper().setBarColor(Color.parseColor("#ffc957"));
      mProgressDialog.setTitleText(context.getResources().getString(R.string.loading));
      if (cancelable) {
        mProgressDialog.setCancelText(context.getString(R.string.dialog_cancel));
        mProgressDialog.setCancelClickListener(sweetAlertDialog -> {
          sweetAlertDialog.cancel();
          if (mProgressCancelListener != null) {
            mProgressCancelListener.onCancelProgress();
          }
        });
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