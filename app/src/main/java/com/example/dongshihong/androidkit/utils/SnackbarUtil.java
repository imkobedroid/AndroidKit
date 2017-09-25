package com.example.dongshihong.androidkit.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

public class SnackbarUtil {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
