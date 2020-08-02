package com.huupt.clonetiki.di.main;

import android.os.Handler;

import androidx.lifecycle.ViewModel;

import com.huupt.clonetiki.viewmodel.MainViewModel;
import com.huupt.clonetiki.adapter.BannerAdapter;
import com.huupt.clonetiki.adapter.FlashDealAdapter;
import com.huupt.clonetiki.adapter.QuickLinkAdapter;
import com.huupt.clonetiki.di.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@Module
public abstract class MainModule {

    @MainScope
    @Provides
    static BannerAdapter provideBannerAdapter(){
        return new BannerAdapter();
    }

    @MainScope
    @Provides
    static Handler provideHandler(){
        return new Handler();
    }

    @MainScope
    @Provides
    static QuickLinkAdapter provideQuickLinkAdapter(){
        return new QuickLinkAdapter();
    }

    @MainScope
    @Provides
    static FlashDealAdapter provideFlashDealAdapter(){
        return new FlashDealAdapter();
    }

    @MainScope
    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);
}
