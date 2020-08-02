package com.huupt.clonetiki.models.flashdeal;

import com.google.gson.annotations.SerializedName;

public class TabsItem{

	@SerializedName("from_date")
	private String fromDate;

	@SerializedName("to_date")
	private String toDate;

	@SerializedName("display")
	private String display;

	@SerializedName("active")
	private boolean active;

	@SerializedName("query_value")
	private int queryValue;

	public String getFromDate(){
		return fromDate;
	}

	public String getToDate(){
		return toDate;
	}

	public String getDisplay(){
		return display;
	}

	public boolean isActive(){
		return active;
	}

	public int getQueryValue(){
		return queryValue;
	}
}