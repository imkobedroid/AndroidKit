package com.amijiaoyu.babybus.android.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;
import com.amijiaoyu.babybus.android.R;
import com.amijiaoyu.babybus.android.weight.PieChart;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/**
 * @author moerlong
 * @date 2018/1/12
 */

public class LoanAdapter extends BaseQuickAdapter<LoginBean, BaseViewHolder> {
    private Context context;

    LoanAdapter(List data, Context context) {
        super(R.layout.item_loan, data);
        this.context = context;
    }

    @Override protected void convert(BaseViewHolder baseViewHolder, LoginBean loginBean) {
        baseViewHolder.setText(R.id.text_name, "贷款一号")
            .setText(R.id.name_content, "贷款一号打开手机付款单技术开发的就是开了房间都是开房间多少空间发的说说水电费第三方")
            .setText(R.id.text_money, "贷款一号")
            .setText(R.id.text_time, "18")
            .setText(R.id.text_repayment, "100")
            .setText(R.id.content_one, "贷款一号")
            .setText(R.id.content_two, "贷款一号")
            .setText(R.id.content_three, "贷款一号")
            .addOnClickListener(R.id.image_select)
            .addOnClickListener(R.id.remove)
            .addOnClickListener(R.id.car)
            .getView(R.id.image_select)
            .setTag(baseViewHolder.getLayoutPosition());
        baseViewHolder.getView(R.id.remove).setTag(baseViewHolder.getLayoutPosition());
        baseViewHolder.getView(R.id.car).setTag(baseViewHolder.getLayoutPosition());
        ((PieChart) baseViewHolder.getView(R.id.myChatView)).initSrc(
            new float[] { 80f, 11.1f, 8.9f }, new String[] {
                "#0177f8", "#ffc600", "#ff9a00"
            });
    }

    @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        //初始化选中状态
        if (LoanActivity.integers.contains(holder.getView(R.id.image_select).getTag())) {
            ((ImageView) holder.getView(R.id.image_select)).setImageResource(
                R.mipmap.selected_highlight);
        } else {
            ((ImageView) holder.getView(R.id.image_select)).setImageResource(
                R.mipmap.selected_normal);
        }

        //初始化购物车状态
        if (LoanActivity.carList.contains(holder.getView(R.id.car).getTag())) {
            ((AppCompatTextView) holder.getView(R.id.car)).setTextColor(
                ContextCompat.getColor(context, R.color.default_blue));
            Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.shopping__highlight);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) holder.getView(R.id.car)).setCompoundDrawables(null, drawable,
                null, null);

            if (LoanActivity.removeList.contains(holder.getView(R.id.remove).getTag())) {
                Drawable drawable_one =
                    ContextCompat.getDrawable(context, R.mipmap.shoping_pressed);
                drawable_one.setBounds(0, 0, drawable_one.getMinimumWidth(),
                    drawable_one.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.car)).setCompoundDrawables(null,
                    drawable_one, null, null);
                ((AppCompatTextView) holder.getView(R.id.car)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray_light));
            } else {
                Drawable drawable_two =
                    ContextCompat.getDrawable(context, R.mipmap.shopping_normal);
                drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                    drawable_two.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.car)).setCompoundDrawables(null,
                    drawable_two, null, null);
                ((AppCompatTextView) holder.getView(R.id.car)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray));
            }
        } else {
            if (LoanActivity.removeList.contains(holder.getView(R.id.remove).getTag())) {
                Drawable drawable_one =
                    ContextCompat.getDrawable(context, R.mipmap.shoping_pressed);
                drawable_one.setBounds(0, 0, drawable_one.getMinimumWidth(),
                    drawable_one.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.car)).setCompoundDrawables(null,
                    drawable_one, null, null);
                ((AppCompatTextView) holder.getView(R.id.car)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray_light));
            } else {
                Drawable drawable_two =
                    ContextCompat.getDrawable(context, R.mipmap.shopping_normal);
                drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                    drawable_two.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.car)).setCompoundDrawables(null,
                    drawable_two, null, null);
                ((AppCompatTextView) holder.getView(R.id.car)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray));
            }
        }



        //初始化移除状态
        if (LoanActivity.removeList.contains(holder.getView(R.id.remove).getTag())) {
            ((AppCompatTextView) holder.getView(R.id.remove)).setTextColor(
                ContextCompat.getColor(context, R.color.default_blue));
            Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.blacklist__highlight);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            ((AppCompatTextView) holder.getView(R.id.remove)).setCompoundDrawables(null, drawable,
                null, null);

            if (LoanActivity.carList.contains(holder.getView(R.id.car).getTag())) {
                Drawable drawable_one =
                    ContextCompat.getDrawable(context, R.mipmap.blacklist_presserd);
                drawable_one.setBounds(0, 0, drawable_one.getMinimumWidth(),
                    drawable_one.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.remove)).setCompoundDrawables(null,
                    drawable_one, null, null);
                ((AppCompatTextView) holder.getView(R.id.remove)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray_light));
            } else {
                Drawable drawable_two =
                    ContextCompat.getDrawable(context, R.mipmap.blacklist_normal);
                drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                    drawable_two.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.remove)).setCompoundDrawables(null,
                    drawable_two, null, null);
                ((AppCompatTextView) holder.getView(R.id.remove)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray));
            }
        } else {
            if (LoanActivity.carList.contains(holder.getView(R.id.car).getTag())) {
                Drawable drawable_one =
                    ContextCompat.getDrawable(context, R.mipmap.blacklist_presserd);
                drawable_one.setBounds(0, 0, drawable_one.getMinimumWidth(),
                    drawable_one.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.remove)).setCompoundDrawables(null,
                    drawable_one, null, null);
                ((AppCompatTextView) holder.getView(R.id.remove)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray_light));
            } else {
                Drawable drawable_two =
                    ContextCompat.getDrawable(context, R.mipmap.blacklist_normal);
                drawable_two.setBounds(0, 0, drawable_two.getMinimumWidth(),
                    drawable_two.getMinimumHeight());
                ((AppCompatTextView) holder.getView(R.id.remove)).setCompoundDrawables(null,
                    drawable_two, null, null);
                ((AppCompatTextView) holder.getView(R.id.remove)).setTextColor(
                    ContextCompat.getColor(context, R.color.default_gray));
            }
        }
    }
}

