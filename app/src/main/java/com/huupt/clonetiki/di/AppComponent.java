package com.huupt.clonetiki.di;

import android.app.Application;

import com.huupt.clonetiki.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        AppModule.class,
        ViewModelFactoryModule.class
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {

        AppComponent create(@BindsInstance Application application);
    }
}
