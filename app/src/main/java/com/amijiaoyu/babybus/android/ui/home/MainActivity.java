package com.amijiaoyu.babybus.android.ui.home;

import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Dsh toushihiroshi on 2018/3/23.
 */

public class MainActivity extends RxActivity{

    @BindView(R.id.begin)AppCompatButton  begin;
    @BindView(R.id.end)AppCompatButton end;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        begin.setOnClickListener(v -> {
            Intent intent = VpnService.prepare(this);
            if (intent != null) {
                startActivityForResult(intent, 0);
            } else {
                onActivityResult(0, RESULT_OK, null);
            }
        });


        Toast.makeText(this,Status.Companion.getStatus(2),Toast.LENGTH_SHORT).show();



    }

    @Override
    protected int getLayout() {
        return R.layout.head_home;
    }

    @Override
    protected void initInject() {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Intent intent = new Intent(this, GITVpnService.class);
            startService(intent);
        }
    }
}
