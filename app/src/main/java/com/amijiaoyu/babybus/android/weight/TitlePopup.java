package com.amijiaoyu.babybus.android.weight;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

import com.amijiaoyu.babybus.android.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongshihong
 */
public class TitlePopup extends PopupWindow {
    private Context mContext;

    /**
     * 列表弹窗的间隔
     */
    protected final int LIST_PADDING = 10;

    /**
     * 实例化一个矩形
     */
    private Rect mRect = new Rect();

    /**
     * 坐标的位置（x、y）
     */
    private final int[] mLocation = new int[2];

    /**
     * 屏幕的宽度和高度
     */
    private int mScreenWidth;

    /**
     * 判断是否需要添加或更新列表子类项
     */
    private boolean mIsDirty;

    /**
     * 位置不在中心
     */
    private int popupGravity = Gravity.NO_GRAVITY;

    /**
     * 弹窗子类项选中时的监听
     */
    private OnItemOnClickListener mItemOnClickListener;

    /**
     * 定义列表对象
     */
    private RecyclerView mListView;

    /**
     * 适配器
     */
    private Adapter adapter;

    /**
     * 定义弹窗子类项列表
     */
    private ArrayList<ActionItem> mActionItems = new ArrayList<>();

    public TitlePopup(Context context) {
        this(context, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    public TitlePopup(Context context, int width, int height) {
        this.mContext = context;

        //设置可以获得焦点
        setFocusable(true);
        //设置弹窗内可点击
        setTouchable(true);
        //设置弹窗外可点击
        setOutsideTouchable(true);

        //获得屏幕的宽度和高度
        Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mScreenWidth = size.x;

        //设置弹窗的宽度和高度
        setWidth(width);
        setHeight(height);

        //setBackgroundDrawable(new BitmapDrawable());

        //设置弹窗的布局界面
        setContentView(LayoutInflater.from(mContext).inflate(R.layout.title_popup, null));

        initUI();
    }

    /**
     * 初始化弹窗列表
     */
    private void initUI() {
        mListView = getContentView().findViewById(R.id.title_list);
    }

    /**
     * 显示弹窗列表界面
     */
    public void show(View view) {
        //获得点击屏幕的位置坐标
        view.getLocationOnScreen(mLocation);

        //设置矩形的大小
        mRect.set(mLocation[0], mLocation[1], mLocation[0] + view.getWidth(),
            mLocation[1] + view.getHeight());

        //判断是否需要添加或更新列表子类项
        if (mIsDirty) {
            populateActions();
        }

        setAnimationStyle(R.style.AnimationPreview);
        //显示弹窗的位置
        showAtLocation(view, popupGravity, mScreenWidth - LIST_PADDING - (getWidth() / 2),
            mRect.bottom);
    }

    /**
     * 设置弹窗列表子项
     */
    private void populateActions() {
        mIsDirty = false;
        adapter = new Adapter(mActionItems);
        mListView.setLayoutManager(new LinearLayoutManager(mContext));
        mListView.setAdapter(adapter);
        adapter.setOnItemClickListener((baseQuickAdapter, view, i) -> {
            //弹窗消失
            dismiss();
            if (mItemOnClickListener != null) {
                mItemOnClickListener.onItemClick(mActionItems.get(i), i);
            }
        });
    }

    /**
     * 添加子类项
     */
    public void addAction(ActionItem action) {
        if (action != null) {
            mActionItems.add(action);
            mIsDirty = true;
        }
    }

    /**
     * 清除子类项
     */
    public void cleanAction() {
        if (mActionItems.isEmpty()) {
            mActionItems.clear();
            mIsDirty = true;
        }
    }

    public interface OnItemOnClickListener {
        /**
         * 点击监听
         * @param item
         * @param position
         */
        void onItemClick(ActionItem item, int position);
    }

    public static class Adapter extends BaseQuickAdapter<ActionItem, BaseViewHolder> {
        private List<ActionItem> data;

        public Adapter(List<ActionItem> data) {
            super(R.layout.item_pop, data);
            this.data = data;
        }

        @Override protected void convert(BaseViewHolder baseViewHolder, ActionItem s) {
            baseViewHolder.setImageDrawable(R.id.icon, s.mDrawable);
            baseViewHolder.setText(R.id.title, s.mTitle);
            if (baseViewHolder.getLayoutPosition() == data.size() - 1) {
                baseViewHolder.getView(R.id.line).setVisibility(View.INVISIBLE);
            }
        }
    }
}