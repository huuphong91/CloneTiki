package com.huupt.clonetiki.viewmodel;

import android.util.Pair;

import androidx.lifecycle.ViewModel;

import com.huupt.clonetiki.models.banner.BannerItem;
import com.huupt.clonetiki.models.banner.BannerResponse;
import com.huupt.clonetiki.models.flashdeal.FlashDealItem;
import com.huupt.clonetiki.models.quicklink.QuickLinkItem;
import com.huupt.clonetiki.network.WebService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private WebService webService;

    @Inject
    public MainViewModel(WebService webService) {
        this.webService = webService;
    }

    private Single<List<BannerItem>> getBanners() {
        return webService.getBannerResponse()
                .map(BannerResponse::getData)
                .onErrorReturn(throwable -> Collections.emptyList());
    }

    private Single<List<QuickLinkItem>> getQuickLinks() {
        return webService.getQuickLinkResponse()
                .map(quickLinkResponse -> {
                    List<List<QuickLinkItem>> quickLinksItems = quickLinkResponse.getData();
                    List<QuickLinkItem> combineList = new ArrayList<>();
                    for (int i = 0; i < quickLinksItems.get(0).size(); i++) {
                        combineList.add(quickLinksItems.get(0).get(i));
                        if (i < quickLinksItems.get(1).size()) {
                            combineList.add(quickLinksItems.get(1).get(i));
                        }
                    }
                    return combineList;
                })
                .onErrorReturn(throwable -> Collections.emptyList());
    }

    public Single<List<FlashDealItem>> getFlashDeals() {
        return webService.getFlashDealResonse()
                .map(flashDealResponse -> {
                    List<FlashDealItem> flashDealItems = flashDealResponse.getData();
                    FlashDealItem flashDealItem = new FlashDealItem();
                    flashDealItem.setTags(("SEE MORE"));
                    flashDealItems.add(flashDealItem);
                    return flashDealItems;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Pair<List<BannerItem>, List<QuickLinkItem>>> getPairList() {
        return getBanners().zipWith(getQuickLinks(), Pair::new)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

