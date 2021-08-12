package com.example.dagger2practice.di;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributesAuthActivity();

    @Provides
    static String providesSomeString() {
        return "This is a sample string";
    }
}
