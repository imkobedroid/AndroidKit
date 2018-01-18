package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.weight.ActionItem;
import com.amijiaoyu.babybus.android.weight.TitlePopup;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class LoanActivity extends RxActivity {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.total)
    AppCompatTextView total;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView title;
    @BindView(R.id.tv_toolbar_right)
    TextView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.match));
        right.setText(R.string.more);
        initRecycleView();
    }

    private void initRecycleView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<LoginBean> loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        LoanAdapter loanAdapter = new LoanAdapter(loginBeans);
        loanAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        loanAdapter.addHeaderView(getLayoutInflater().inflate(R.layout.head_loan, null));
        recycleView.setAdapter(loanAdapter);


        right.setOnClickListener(v -> {
            TitlePopup titlePopup = new TitlePopup(this, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            titlePopup.addAction(new ActionItem(this, "编辑需求", R.mipmap.black_name));
            titlePopup.addAction(new ActionItem(this, "编辑资质", R.mipmap.black_name));
            titlePopup.addAction(new ActionItem(this, "购物车(12)", R.mipmap.black_name));
            titlePopup.addAction(new ActionItem(this, "黑名单(12)",R.mipmap.black_name));
            titlePopup.show(v);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_loan;
    }

    @Override
    protected void initInject() {

    }


}
