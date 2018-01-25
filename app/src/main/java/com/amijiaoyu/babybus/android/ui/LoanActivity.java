package com.amijiaoyu.babybus.android.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.base.RxActivity;
import com.amijiaoyu.babybus.android.weight.ActionItem;
import com.amijiaoyu.babybus.android.weight.TitlePopup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dsh
 */

@SuppressLint("Registered") public class LoanActivity extends RxActivity
    implements TitlePopup.OnItemOnClickListener, BaseQuickAdapter.OnItemChildClickListener,
    View.OnClickListener {
    @BindView(R.id.recycleView) RecyclerView recycleView;
    @BindView(R.id.total) AppCompatTextView total;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tv_toolbar) TextView title;
    @BindView(R.id.tv_toolbar_right) TextView right;
    @BindView(R.id.next) AppCompatTextView next;
    public static List<Integer> integers;
    public static List<Integer> carList;
    public static List<Integer> removeList;
    private List<LoginBean> container;
    private List<LoginBean> loginBeans;
    private LoanAdapter loanAdapter;
    private static final int ITEM_POSITION_ONE = 0;
    private static final int ITEM_POSITION_TWO = 1;
    private static final int ITEM_POSITION_THREE = 2;
    private static final int ITEM_POSITION_FOUR = 3;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initListener();
        initView();
    }

    private void initListener() {
        next.setOnClickListener(this);
    }

    private void initView() {
        initToolBar(toolbar, title, getString(R.string.match));
        right.setText(R.string.more);
        initRecycleView();
    }

    private void initRecycleView() {
        container = new ArrayList<>();
        carList = new ArrayList<>();
        removeList = new ArrayList<>();
        integers = new ArrayList<>();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        loginBeans = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            loginBeans.add(new LoginBean());
        }
        loanAdapter = new LoanAdapter(loginBeans, this);
        loanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        loanAdapter.setOnItemChildClickListener(this);
        recycleView.setNestedScrollingEnabled(false);
        recycleView.setAdapter(loanAdapter);

        right.setOnClickListener(v -> {
            TitlePopup titlePopup = new TitlePopup(this, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, this);
            titlePopup.addAction(new ActionItem(this, "编辑需求", R.mipmap.loan_demand));
            titlePopup.addAction(new ActionItem(this, "编辑资质", R.mipmap.loan_aptitude));
            titlePopup.addAction(new ActionItem(this, "购物车(12)", R.mipmap.loan_shopping));
            titlePopup.addAction(new ActionItem(this, "黑名单(12)", R.mipmap.loan_blacklis));
            titlePopup.show(v);
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
        switch (view.getId()) {
            case R.id.image_select:
                if (integers.contains(view.getTag())) {
                    integers.remove(view.getTag());
                    ((ImageView) view).setImageResource(R.mipmap.selected_normal);
                } else {
                    integers.add(position);
                    ((ImageView) view).setImageResource(R.mipmap.selected_highlight);
                }
                break;
            case R.id.remove:
                removeFunction(view, position);
                break;
            case R.id.car:
                carFunction(view, position);
                break;
            default:
        }
    }

    @Override protected int getLayout() {
        return R.layout.activity_loan;
    }

    @Override protected void initInject() {

    }

    @Override public void onItemClick(ActionItem item, int position) {
        switch (position) {
            case ITEM_POSITION_ONE:
                //编辑需求
                startActivity(new Intent(this, QualificationsEditActivity.class));
                break;
            case ITEM_POSITION_TWO:
                //编辑资质
                startActivity(new Intent(this, EditQualificationsActivity.class));
                break;
            case ITEM_POSITION_THREE:
                //购物车
                startActivity(new Intent(this, ShoppingActivity.class));
                break;
            case ITEM_POSITION_FOUR:
                //黑名单
                startActivity(new Intent(this, BlackActivity.class));
                break;
            default:
        }
    }

    /**
     * 最终拿到的要生成方案的数据
     */
    private List<LoginBean> getSelectFinalData() {
        container.clear();
        for (int a = 0; a < integers.size(); a++) {
            container.add(loginBeans.get(integers.get(a)));
        }
        return container;
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                Toast.makeText(this, getSelectFinalData().size() + "", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }

    private void carFunction(View view, int position) {
        if (carList.contains(view.getTag())) {
            carList.remove(view.getTag());
            Drawable drawable_two = ContextCompat.getDrawable(this, R.mipmap.shopping_normal);
            drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                drawable_two.getMinimumHeight());
            ((AppCompatTextView) view).setCompoundDrawables(null, drawable_two, null, null);
            ((AppCompatTextView) view).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray));

            View remove =
                ((BaseViewHolder) recycleView.findViewHolderForAdapterPosition(position)).getView(
                    R.id.remove);
            remove.setClickable(true);
            Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.blacklist_normal);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) remove).setCompoundDrawables(null, drawable, null, null);
            ((AppCompatTextView) remove).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray));
        } else {
            carList.add(position);
            Drawable drawable_two = ContextCompat.getDrawable(this, R.mipmap.shopping__highlight);
            drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                drawable_two.getMinimumHeight());
            ((AppCompatTextView) view).setCompoundDrawables(null, drawable_two, null, null);
            ((AppCompatTextView) view).setTextColor(
                ContextCompat.getColor(this, R.color.default_blue));

            View remove =
                ((BaseViewHolder) recycleView.findViewHolderForAdapterPosition(position)).getView(
                    R.id.remove);
            remove.setClickable(false);
            Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.blacklist_presserd);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) remove).setCompoundDrawables(null, drawable, null, null);
            ((AppCompatTextView) remove).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray_light));
        }
    }

    private void removeFunction(View view, int position) {
        if (removeList.contains(view.getTag())) {
            removeList.remove(view.getTag());
            Drawable drawable_two = ContextCompat.getDrawable(this, R.mipmap.blacklist_normal);
            drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                drawable_two.getMinimumHeight());
            ((AppCompatTextView) view).setCompoundDrawables(null, drawable_two, null, null);
            ((AppCompatTextView) view).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray));

            View remove =
                ((BaseViewHolder) recycleView.findViewHolderForAdapterPosition(position)).getView(
                    R.id.car);
            remove.setClickable(true);
            Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.shopping_normal);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) remove).setCompoundDrawables(null, drawable, null, null);
            ((AppCompatTextView) remove).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray));
        } else {
            removeList.add(position);
            Drawable drawable_two = ContextCompat.getDrawable(this, R.mipmap.blacklist__highlight);
            drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                drawable_two.getMinimumHeight());
            ((AppCompatTextView) view).setCompoundDrawables(null, drawable_two, null, null);
            ((AppCompatTextView) view).setTextColor(
                ContextCompat.getColor(this, R.color.default_blue));

            View remove =
                ((BaseViewHolder) recycleView.findViewHolderForAdapterPosition(position)).getView(
                    R.id.car);
            remove.setClickable(false);
            Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.shoping_pressed);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) remove).setCompoundDrawables(null, drawable, null, null);
            ((AppCompatTextView) remove).setTextColor(
                ContextCompat.getColor(this, R.color.default_gray_light));
        }
    }
}
