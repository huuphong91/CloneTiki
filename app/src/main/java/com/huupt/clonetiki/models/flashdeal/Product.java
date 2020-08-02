package com.huupt.clonetiki.models.flashdeal;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Product{

	@SerializedName("master_id")
	private int masterId;

	@SerializedName("rating_average")
	private int ratingAverage;

	@SerializedName("is_visible")
	private boolean isVisible;

	@SerializedName("order_count")
	private int orderCount;

	@SerializedName("discount")
	private int discount;

	@SerializedName("review_count")
	private int reviewCount;

	@SerializedName("price_prefix")
	private String pricePrefix;

	@SerializedName("list_price")
	private int listPrice;

	@SerializedName("thumbnail_url")
	private String thumbnailUrl;

	@SerializedName("inventory")
	private Inventory inventory;

	@SerializedName("is_flower")
	private boolean isFlower;

	@SerializedName("url_attendant_input_form")
	private String urlAttendantInputForm;

	@SerializedName("is_fresh")
	private boolean isFresh;

	@SerializedName("seller_product_id")
	private int sellerProductId;

	@SerializedName("badges")
	private List<Object> badges;

	@SerializedName("price")
	private int price;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("sku")
	private Object sku;

	@SerializedName("url_path")
	private String urlPath;

	@SerializedName("is_gift_card")
	private boolean isGiftCard;

	public int getMasterId(){
		return masterId;
	}

	public int getRatingAverage(){
		return ratingAverage;
	}

	public boolean isIsVisible(){
		return isVisible;
	}

	public int getOrderCount(){
		return orderCount;
	}

	public int getDiscount(){
		return discount;
	}

	public int getReviewCount(){
		return reviewCount;
	}

	public String getPricePrefix(){
		return pricePrefix;
	}

	public int getListPrice(){
		return listPrice;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public Inventory getInventory(){
		return inventory;
	}

	public boolean isIsFlower(){
		return isFlower;
	}

	public String getUrlAttendantInputForm(){
		return urlAttendantInputForm;
	}

	public boolean isIsFresh(){
		return isFresh;
	}

	public int getSellerProductId(){
		return sellerProductId;
	}

	public List<Object> getBadges(){
		return badges;
	}

	public int getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Object getSku(){
		return sku;
	}

	public String getUrlPath(){
		return urlPath;
	}

	public boolean isIsGiftCard(){
		return isGiftCard;
	}
}