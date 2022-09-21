package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.ItemDTO;
import com.multi.service.ItemService;

@SpringBootTest
class UpdateItem {
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		ItemDTO item = new ItemDTO(101, 11, 616, "배", 7000, null, null);
		try {
			service.modify(item);
			System.out.println("update ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
