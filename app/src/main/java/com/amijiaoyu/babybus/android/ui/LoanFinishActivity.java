package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class LoanFinishActivity extends RxActivity{
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
        right.setText(R.string.finish);
        initRecycleView();
    }

    private void initRecycleView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<LoginBean> loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        LoanAdapter loanAdapter = new LoanAdapter(loginBeans,this);
        loanAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recycleView.setAdapter(loanAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_loan_finish;
    }

    @Override
    protected void initInject() {

    }

}
