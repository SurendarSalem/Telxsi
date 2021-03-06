package com.sonyliv.daggerpractice;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AppApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
