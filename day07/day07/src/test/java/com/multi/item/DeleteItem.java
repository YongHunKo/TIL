package com.multi.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.ItemService;

@SpringBootTest
class DeleteItem {
	@Autowired
	ItemService service;

	@Test
	void contextLoads() {
		try {
			service.remove(102);
			System.out.println("remove ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
