package com.huupt.clonetiki.models.flashdeal;

import com.google.gson.annotations.SerializedName;

public class Inventory{

	@SerializedName("fulfillment_type")
	private String fulfillmentType;

	@SerializedName("product_virtual_type")
	private Object productVirtualType;

	public String getFulfillmentType(){
		return fulfillmentType;
	}

	public Object getProductVirtualType(){
		return productVirtualType;
	}
}