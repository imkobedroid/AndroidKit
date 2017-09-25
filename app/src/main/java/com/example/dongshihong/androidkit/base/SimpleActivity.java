package com.example.dongshihong.androidkit.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.dongshihong.androidkit.R;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */
public abstract class SimpleActivity extends AppCompatActivity {

  protected Activity mContext;
  private Unbinder mUnBinder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    mUnBinder = ButterKnife.bind(this);
    mContext = this;
    onViewCreated();
  }

  protected void setToolBar(Toolbar toolbar, TextView mTvToolbar, String title) {
    toolbar.setTitle("");
    mTvToolbar.setText(title);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
    toolbar.setNavigationOnClickListener(view -> finish());
  }


  protected void onViewCreated() {

  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mUnBinder.unbind();
  }

  protected abstract int getLayout();

}
