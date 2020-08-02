package com.huupt.clonetiki.models.flashdeal;

import com.google.gson.annotations.SerializedName;

public class Progress{

	@SerializedName("qty_remain")
	private int qtyRemain;

	@SerializedName("qty")
	private int qty;

	@SerializedName("qty_ordered")
	private int qtyOrdered;

	@SerializedName("percent")
	private double percent;

	@SerializedName("status")
	private String status;

	public int getQtyRemain(){
		return qtyRemain;
	}

	public int getQty(){
		return qty;
	}

	public int getQtyOrdered(){
		return qtyOrdered;
	}

	public double getPercent(){
		return percent;
	}

	public String getStatus(){
		return status;
	}
}