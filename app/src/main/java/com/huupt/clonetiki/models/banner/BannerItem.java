package com.huupt.clonetiki.models.banner;

import com.google.gson.annotations.SerializedName;

public class BannerItem {

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("mobile_url")
	private String mobileUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("thumbnail_url")
	private String thumbnailUrl;

	@SerializedName("content")
	private String content;

	@SerializedName("url")
	private String url;

	@SerializedName("ratio")
	private double ratio;

	public String getImageUrl(){
		return imageUrl;
	}

	public String getMobileUrl(){
		return mobileUrl;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public String getContent(){
		return content;
	}

	public String getUrl(){
		return url;
	}

	public double getRatio(){
		return ratio;
	}
}