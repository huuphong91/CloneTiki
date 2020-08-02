package com.huupt.clonetiki.models.flashdeal;

import com.google.gson.annotations.SerializedName;

public class FlashDealItem {

	@SerializedName("product")
	private Product product;

	@SerializedName("from_date")
	private String fromDate;

	@SerializedName("special_price")
	private int specialPrice;

	@SerializedName("progress")
	private Progress progress;

	@SerializedName("special_from_date")
	private int specialFromDate;

	@SerializedName("discount_percent")
	private int discountPercent;

	@SerializedName("url")
	private String url;

	@SerializedName("status")
	private int status;

	@SerializedName("tags")
	private String tags;

	@SerializedName("special_to_date")
	private int specialToDate;

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Product getProduct(){
		return product;
	}

	public String getFromDate(){
		return fromDate;
	}

	public int getSpecialPrice(){
		return specialPrice;
	}

	public Progress getProgress(){
		return progress;
	}

	public int getSpecialFromDate(){
		return specialFromDate;
	}

	public int getDiscountPercent(){
		return discountPercent;
	}

	public String getUrl(){
		return url;
	}

	public int getStatus(){
		return status;
	}

	public String getTags(){
		return tags;
	}

	public int getSpecialToDate(){
		return specialToDate;
	}
}