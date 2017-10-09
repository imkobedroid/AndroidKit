package com.example.dongshihong.androidkit.di.assist;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */

public class InitializeService extends IntentService {

  private static final String ACTION_INIT = "initApplication";

  public InitializeService() {
    super("InitializeService");
  }

  public static void start(Context context) {
    Intent intent = new Intent(context, InitializeService.class);
    intent.setAction(ACTION_INIT);
    context.startService(intent);
  }

  @Override protected void onHandleIntent(Intent intent) {
   /* if (intent != null) {
      final String action = intent.getAction();
      if (ACTION_INIT.equals(action)) {
      }
    }*/
  }}
