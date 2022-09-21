package com.multi.requestdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.RequestDetailService;

@SpringBootTest
class DeleteRequestDetail {
	@Autowired
	RequestDetailService service;

	@Test
	void contextLoads() {
		try {
			service.remove("a");
			System.out.println("remove ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
