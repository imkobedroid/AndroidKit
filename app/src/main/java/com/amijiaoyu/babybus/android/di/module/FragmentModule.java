package com.amijiaoyu.babybus.android.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.amijiaoyu.babybus.android.di.assist.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Author:Dsh
 * Date:2017/9/25 11:37
 * Email:imkobedroid@gmail.com
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public Fragment getFragment(){
        return fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity(Fragment fragment) {
        return fragment.getActivity();
    }
}
