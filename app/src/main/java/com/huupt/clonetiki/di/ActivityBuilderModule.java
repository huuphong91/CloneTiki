package com.huupt.clonetiki.di;

import com.huupt.clonetiki.MainActivity;
import com.huupt.clonetiki.di.main.MainModule;
import com.huupt.clonetiki.di.main.MainScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(
            modules = {MainModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
