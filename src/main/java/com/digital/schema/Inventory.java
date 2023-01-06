package com.digital.schema;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Inventory {

	@ApiModelProperty(required = true, position = 1, example = "1243", dataType = "long", notes = "상품 ID")
	private long productId;
	@ApiModelProperty(required = true, position = 2, example = "100", dataType = "String", notes = "상품 수량")
	private long quantity;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
