package com.digital.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.digital.schema.Inventory;
import com.digital.sql.mapper.InventoryMapper;
import com.digital.sql.vo.InventoryVO;

@Component
public class InventoryService {

	@Resource
	InventoryMapper inventoryMapper;

	// 재고 검색 (이름)
	public Inventory searchInventory(String productName) {

		InventoryVO inventoryVO = inventoryMapper.getInventory(productName);
		Inventory inventory = new Inventory();

		if (inventoryVO != null) {
			inventory.setProductId(inventoryVO.getProductId());
			inventory.setQuantity(inventoryVO.getQuantity());
		}
		return inventory;
	}

	// 재고 정보 가져오기 (상품 ID)
	public Inventory searchInventoryById(Inventory inventory) {

		InventoryVO inventoryVO = inventoryMapper.getInventoryById(inventory.getProductId());
		Inventory inventory_res = new Inventory();

		if (inventoryVO != null) {
			inventory_res.setProductId(inventoryVO.getProductId());
			inventory_res.setQuantity(inventoryVO.getQuantity());
		}
		
		return inventory_res;
	}

	// 재고 등록
	public boolean insertInventory(Inventory inventory) throws Exception {

		InventoryVO inventoryVO = new InventoryVO();

		try {
			// 재고 중복 여부
			if (inventoryMapper.getInventoryById(inventory.getProductId()) != null) {
				// 해당 재고 업데이트
				updateInventory(inventory);

				return true;
			}
			inventoryVO.setProductId(inventory.getProductId());
			inventoryVO.setQuantity(inventory.getQuantity());

			inventoryMapper.setInventory(inventoryVO);

			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	// 재고 수량 변경
	public boolean updateInventory(Inventory inventory) throws Exception {

		InventoryVO inventoryVO = new InventoryVO();

		try {
			inventoryVO.setProductId(inventory.getProductId());
			inventoryVO.setQuantity(inventory.getQuantity());

			inventoryMapper.updateInventory(inventoryVO);

			return true;
		} catch (Exception e) {
			throw e;
		}
	}

}
