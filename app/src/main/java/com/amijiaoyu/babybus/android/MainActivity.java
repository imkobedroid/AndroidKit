package com.amijiaoyu.babybus.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amijiaoyu.babybus.android.blank.ContentPresenter;
import com.amijiaoyu.babybus.android.blank.EmptyView;
import com.amijiaoyu.babybus.android.blank.ErrorView;
import com.amijiaoyu.babybus.android.blank.RequiresContent;
import com.amijiaoyu.babybus.android.blank.ReflectionContentPresenterFactory;

@RequiresContent public class MainActivity extends AppCompatActivity
    implements EmptyView.OnEmptyViewClickListener, ErrorView.OnErrorViewClickListener {
  private ContentPresenter contentPresenter;
  private ReflectionContentPresenterFactory factory;
  private FrameLayout container;
  private TextView support_ui_content_view;
  private TextView kong;
  private TextView error;
  private TextView load;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    container = findViewById(R.id.container);
    support_ui_content_view = findViewById(R.id.support_ui_content_view);
    kong = findViewById(R.id.kong);
    error = findViewById(R.id.error);
    load = findViewById(R.id.load);
    init();
    click();
  }

  private void click() {
    kong.setOnClickListener(view -> contentPresenter.buildEmptyImageView(R.drawable.support_ui_empty)
        .buildEmptyTitle(R.string.support_ui_empty_title_placeholder)
        .buildEmptySubtitle(R.string.support_ui_empty_subtitle_placeholder)
        .displayEmptyView());
    error.setOnClickListener(view -> contentPresenter.buildErrorImageView(R.drawable.support_ui_network_error)
        .buildEmptyTitle(R.string.support_ui_error_title_placeholder)
        .buildEmptySubtitle(R.string.support_ui_error_subtitle_placeholder)
        .displayEmptyView());
    load.setOnClickListener(view -> contentPresenter.displayLoadView());
  }

  private void init() {
    factory = ReflectionContentPresenterFactory.fromViewClass(getClass());
    contentPresenter = factory.createContentPresenter();
    contentPresenter.onCreate(this);
    contentPresenter.attachContainer(container);
    contentPresenter.attachContentView(support_ui_content_view);
    contentPresenter.setOnEmptyViewClickListener(this);
    contentPresenter.setOnErrorViewClickListener(this);
  }

  @Override public void onEmptyViewClick(View view) {
    contentPresenter.displayLoadView();
  }

  @Override public void onErrorViewClick(View view) {
    contentPresenter.displayLoadView();
  }

  @Override protected void onResume() {
    super.onResume();
    contentPresenter.attachContainer(container);
    contentPresenter.attachContentView(support_ui_content_view);
  }

  @Override public void onPause() {
    super.onPause();
    contentPresenter.onDestroyView();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    contentPresenter.onDestroy();
    contentPresenter = null;
  }
}
