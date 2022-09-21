package com.multi.requestdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.RequestDetailDTO;
import com.multi.service.RequestDetailService;

@SpringBootTest
class InsertRequestDetail {
	@Autowired
	RequestDetailService service;

	@Test
	void contextLoads() {
		RequestDetailDTO rd = new RequestDetailDTO("a", 1, 101, 0, 0, 5);
		try {
			service.register(rd);
			System.out.println("insert ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
