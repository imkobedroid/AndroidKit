package com.amijiaoyu.babybus.android.model.rx;

import android.content.Context;
import com.amijiaoyu.babybus.android.R;

/**
 * Created by Dsh on 2017/5/8.
 * Use:
 */

public class ErrorMessageFactory {

  public static String create(Context context, int code) {

    String errorMsg;

    switch (code) {

      case BaseException.HTTP_ERROR:

        errorMsg = context.getResources().getString(R.string.error_http);

        break;
      case BaseException.API_ERROR:

        errorMsg = context.getResources().getString(R.string.error_api);

        break;
      case BaseException.ERROR_TRANSFORMER:

        errorMsg = context.getResources().getString(R.string.error_transformer);

        break;
      case BaseException.UNKOWNHOST_ERROR:

        errorMsg = context.getResources().getString(R.string.error_api);

        break;

      case BaseException.SOCKET_TIMEOUT_ERROR:

        errorMsg = context.getResources().getString(R.string.error_socket_timeout);

        break;
      case BaseException.JSON_ERROR:

        errorMsg = context.getResources().getString(R.string.error_change);

        break;
      case BaseException.UNKNOWN_ERROR:

        errorMsg = context.getResources().getString(R.string.error_know);

        break;
      case BaseException.SOCKET_ERROR:

        errorMsg = context.getResources().getString(R.string.error_socket_unreachable);

        break;

      case BaseException.ERROR_HTTP_400:

        errorMsg = context.getResources().getString(R.string.error_http_400);

        break;

      case BaseException.ERROR_HTTP_404:

        errorMsg = context.getResources().getString(R.string.error_http_404);

        break;

      case BaseException.ERROR_HTTP_500:

        errorMsg = context.getResources().getString(R.string.error_http_500);

        break;
      case BaseException.ERROR_HTTP_405:

        errorMsg = context.getResources().getString(R.string.error_http_402);

        break;

      case ApiException.ERROR_API_SYSTEM:
        errorMsg = context.getResources().getString(R.string.error_system);
        break;

      default:
        errorMsg = context.getResources().getString(R.string.error_know);
        break;
    }

    return errorMsg;
  }
}
