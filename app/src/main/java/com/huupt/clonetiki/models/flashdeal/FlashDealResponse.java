package com.huupt.clonetiki.models.flashdeal;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FlashDealResponse{

	@SerializedName("data")
	private List<FlashDealItem> data;

	@SerializedName("tabs")
	private List<TabsItem> tabs;

	@SerializedName("version")
	private String version;

	public List<FlashDealItem> getData(){
		return data;
	}

	public List<TabsItem> getTabs(){
		return tabs;
	}

	public String getVersion(){
		return version;
	}
}