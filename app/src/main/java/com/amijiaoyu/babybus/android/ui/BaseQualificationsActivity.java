package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author moerlong
 */

@SuppressLint("Registered")
public class BaseQualificationsActivity extends RxActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbar)
    TextView title;

    @BindView(R.id.full_house)
    RecyclerView fullHouse;
    @BindView(R.id.mortgage_house)
    RecyclerView mortgageHouse;

    @BindView(R.id.full_car)
    RecyclerView fullCar;
    @BindView(R.id.mortgage_car)
    RecyclerView mortgageCar;

    @BindView(R.id.policy)
    RecyclerView policy;

    @BindView(R.id.view_four)
    RelativeLayout viewFour;

    private FullHouseAdapter fullHouseAdapter;
    private MortgageHouseAdapter mortgageHouseAdapter;
    private FullCarAdapter fullCarAdapter;
    private MortgageCarAdapter mortgageCarAdapter;
    private PolicyAdapter policyAdapter;
    private View fullHouseFoot;
    private View mortgageHouseFoot;
    private View fullCarFoot;
    private View mortgageCarFoot;
    private View policyFoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.info));
        viewFour.setOnClickListener(v -> startActivity(new Intent(this,BaseCreditActivity.class)));
        initRecyclerView();
    }

    @SuppressLint("InflateParams")
    private void initRecyclerView() {
        List<String> data = new ArrayList<>();
        fullHouseAdapter = new FullHouseAdapter(data);
        mortgageHouseAdapter = new MortgageHouseAdapter(data);
        fullCarAdapter = new FullCarAdapter(data);
        mortgageCarAdapter = new MortgageCarAdapter(data);
        policyAdapter = new PolicyAdapter(data);

        fullHouseFoot = this.getLayoutInflater().inflate(R.layout.item_foot, null);
        mortgageHouseFoot = this.getLayoutInflater().inflate(R.layout.item_foot, null);
        fullCarFoot = this.getLayoutInflater().inflate(R.layout.item_foot, null);
        mortgageCarFoot = this.getLayoutInflater().inflate(R.layout.item_foot, null);
        policyFoot = this.getLayoutInflater().inflate(R.layout.item_foot, null);

        fullHouseAdapter.setFooterView(fullHouseFoot);
        mortgageHouseAdapter.setFooterView(mortgageHouseFoot);
        fullCarAdapter.setFooterView(fullCarFoot);
        mortgageCarAdapter.setFooterView(mortgageCarFoot);
        policyAdapter.setFooterView(policyFoot);


        fullHouse.setLayoutManager(new LinearLayoutManager(this));
        mortgageHouse.setLayoutManager(new LinearLayoutManager(this));
        fullCar.setLayoutManager(new LinearLayoutManager(this));
        mortgageCar.setLayoutManager(new LinearLayoutManager(this));
        policy.setLayoutManager(new LinearLayoutManager(this));

        fullHouse.setAdapter(fullHouseAdapter);
        mortgageHouse.setAdapter(mortgageHouseAdapter);
        fullCar.setAdapter(fullCarAdapter);
        mortgageCar.setAdapter(mortgageCarAdapter);
        policy.setAdapter(policyAdapter);

        initFootClick();

    }

    private void initFootClick() {
        fullHouseFoot.setOnClickListener(v -> {
            startActivity(new Intent(this, AddInfoActivity.class));
        });
        mortgageHouseFoot.setOnClickListener(v -> {
            startActivity(new Intent(this, AddInfoActivity.class));
        });
        fullCarFoot.setOnClickListener(v -> {
            startActivity(new Intent(this, AddInfoActivity.class));
        });
        mortgageCarFoot.setOnClickListener(v -> {
            startActivity(new Intent(this, AddInfoActivity.class));
        });
        policyFoot.setOnClickListener(v -> {
            startActivity(new Intent(this, AddInfoActivity.class));
        });


    }


    @Override
    protected int getLayout() {
        return R.layout.activity_qualifications;
    }

    @Override
    protected void initInject() {

    }


    class FullHouseAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        FullHouseAdapter(@Nullable List<String> data) {
            super(R.layout.layout_custom, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class MortgageHouseAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        MortgageHouseAdapter(@Nullable List<String> data) {
            super(R.layout.layout_custom, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class FullCarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        FullCarAdapter(@Nullable List<String> data) {
            super(R.layout.layout_custom, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class MortgageCarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        MortgageCarAdapter(@Nullable List<String> data) {
            super(R.layout.layout_custom, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class PolicyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        PolicyAdapter(@Nullable List<String> data) {
            super(R.layout.layout_custom, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

}
