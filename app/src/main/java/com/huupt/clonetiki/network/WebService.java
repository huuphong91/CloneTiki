package com.huupt.clonetiki.network;

import com.huupt.clonetiki.models.banner.BannerResponse;
import com.huupt.clonetiki.models.flashdeal.FlashDealResponse;
import com.huupt.clonetiki.models.quicklink.QuickLinkResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface WebService {

    @GET("v2/home/banners/v2")
    Single<BannerResponse> getBannerResponse();

    @GET("shopping/v2/widgets/quick_link")
    Single<QuickLinkResponse> getQuickLinkResponse();

    @GET("v2/widget/deals/hot")
    Single<FlashDealResponse> getFlashDealResonse();
}
