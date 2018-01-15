package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.match));
        initRecycleView();
    }

    private void initRecycleView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<LoginBean> loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        LoanAdapter loanAdapter = new LoanAdapter(loginBeans);
        loanAdapter.addHeaderView(getLayoutInflater().inflate(R.layout.head_loan, null));
        recycleView.setAdapter(loanAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_loan;
    }

    @Override
    protected void initInject() {

    }

}
