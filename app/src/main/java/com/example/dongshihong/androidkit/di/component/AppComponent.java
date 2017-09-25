package com.example.dongshihong.androidkit.di.component;

import com.example.dongshihong.androidkit.app.App;
import com.example.dongshihong.androidkit.di.module.AppModule;
import com.example.dongshihong.androidkit.di.module.HttpModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

@Singleton @Component(modules = { AppModule.class, HttpModule.class })
public interface AppComponent {
  App getContext();
}
