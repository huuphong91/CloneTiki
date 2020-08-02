package com.huupt.clonetiki;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;

import com.huupt.clonetiki.adapter.BannerAdapter;
import com.huupt.clonetiki.adapter.FlashDealAdapter;
import com.huupt.clonetiki.adapter.QuickLinkAdapter;
import com.huupt.clonetiki.di.ViewModelProviderFactory;
import com.huupt.clonetiki.models.banner.BannerItem;
import com.huupt.clonetiki.models.quicklink.QuickLinkItem;
import com.huupt.clonetiki.viewmodel.MainViewModel;
import com.huupt.clonetiki.viewpagerdotsindicator.WormDotsIndicator;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    BannerAdapter bannerAdapter;
    @Inject
    QuickLinkAdapter quickLinkAdapter;
    @Inject
    FlashDealAdapter flashDealAdapter;
    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    CompositeDisposable compositeDisposable;
    @Inject
    Handler sliderHandler;

    private MainViewModel viewModel;

    private ViewPager2 vpBannerSlide;
    private RecyclerView rvQLink;
    private RecyclerView rvFlashDeal;
    private WormDotsIndicator dotsIndicator;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<QuickLinkItem> quickLinkItems;
    private ProgressBar progressBar;
    private ConstraintLayout rootViewFlashDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quickLinkItems = Collections.emptyList();

        vpBannerSlide = findViewById(R.id.vpBannerSlide);
        rvQLink = findViewById(R.id.rvQLink);
        rvFlashDeal = findViewById(R.id.rvFlashDeal);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        dotsIndicator = findViewById(R.id.dots_indicator);
        progressBar = findViewById(R.id.progressBar5);
        rootViewFlashDeal = findViewById(R.id.rootViewFlashDeal);

        vpBannerSlide.setAdapter(bannerAdapter);
        rvQLink.setAdapter(quickLinkAdapter);
        rvFlashDeal.setAdapter(flashDealAdapter);

        viewModel = new ViewModelProvider(this, providerFactory).get(MainViewModel.class);

        vpBannerSlide.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
        vpBannerSlide.setOffscreenPageLimit(4);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            progressBar.setVisibility(View.VISIBLE);
            subscribe();
        });

        subscribe();
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            vpBannerSlide.setCurrentItem(vpBannerSlide.getCurrentItem() + 1);
        }
    };

    private void subscribe() {
        compositeDisposable.add(viewModel.getPairList()
                .doOnSuccess(listListPair -> {
                    quickLinkItems = listListPair.second;
                    if (!listListPair.first.isEmpty()) {
                        List<BannerItem> bannerItems = listListPair.first;
                        bannerAdapter.setListBanners(bannerItems);
                        vpBannerSlide.setCurrentItem((Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2) % bannerItems.size());
                        dotsIndicator.setViewPager2(vpBannerSlide, bannerItems.size());
                    } else if (!listListPair.second.isEmpty()) {
                        quickLinkAdapter.setListQuickLinks(quickLinkItems);
                    } else {
                        quickLinkItems = null;
                    }
                })
                .concatMap(listListPair -> viewModel.getFlashDeals())
                .subscribe(flashDealItems -> {
                    if (quickLinkItems.isEmpty()) {
                        flashDealAdapter.setListFlashDeals(flashDealItems);
                    }

                    vpBannerSlide.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (vpBannerSlide.getHeight() > 0) {
                                progressBar.setVisibility(View.GONE);
                                vpBannerSlide.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                if (!quickLinkItems.isEmpty()) {
                                    progressBar.setVisibility(View.VISIBLE);
                                    quickLinkAdapter.setListQuickLinks(quickLinkItems);
                                }
                            }
                        }
                    });

                    rvQLink.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (rvQLink.getHeight() > 0) {
                                progressBar.setVisibility(View.GONE);
                                rvQLink.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                if (!flashDealItems.isEmpty()) {
                                    progressBar.setVisibility(View.VISIBLE);
                                    flashDealAdapter.setListFlashDeals(flashDealItems);
                                }
                            }
                        }
                    });

                    rvFlashDeal.getViewTreeObserver().addOnGlobalLayoutListener(() -> {
                        if(rvFlashDeal.getHeight() > 0){
                            rootViewFlashDeal.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}