package com.digital.sql.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.digital.sql.vo.InventoryVO;

@Mapper
public interface InventoryMapper {

	public InventoryVO getInventory(String productName);

	public void setInventory(InventoryVO inventoryVO);

	public void updateInventory(InventoryVO inventoryVO);

	public InventoryVO getInventoryById(long productId);

}
