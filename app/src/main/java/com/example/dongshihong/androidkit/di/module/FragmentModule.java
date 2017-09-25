package com.example.dongshihong.androidkit.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.example.dongshihong.androidkit.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
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
