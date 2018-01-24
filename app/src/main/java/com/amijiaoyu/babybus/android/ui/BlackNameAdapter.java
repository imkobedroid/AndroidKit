package com.amijiaoyu.babybus.android.ui;

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

public class BlackNameAdapter extends BaseQuickAdapter<LoginBean, BaseViewHolder> {

    BlackNameAdapter(List data) {
        super(R.layout.item_back_name, data);
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
            .getView(R.id.image_select)
            .setTag(baseViewHolder.getLayoutPosition());
        ((PieChart) baseViewHolder.getView(R.id.myChatView)).initSrc(
            new float[] { 80f, 11.1f, 8.9f }, new String[] {
                "#0177f8", "#ffc600", "#ff9a00"
            });
    }

    @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (BlackActivity.integers.contains(holder.getView(R.id.image_select).getTag())) {
            ((ImageView)holder.getView(R.id.image_select)).setImageResource(R.mipmap.selected_highlight);
        } else {
            ((ImageView)holder.getView(R.id.image_select)).setImageResource(R.mipmap.selected_normal);
        }
    }
}
