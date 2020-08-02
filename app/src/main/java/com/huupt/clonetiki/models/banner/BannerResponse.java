package com.huupt.clonetiki.models.banner;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BannerResponse {

	@SerializedName("data")
	private List<BannerItem> data;

	public List<BannerItem> getData(){
		return data;
	}
}