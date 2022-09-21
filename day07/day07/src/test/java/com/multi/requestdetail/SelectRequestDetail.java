package com.multi.requestdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.RequestDetailDTO;
import com.multi.service.RequestDetailService;

@SpringBootTest
class SelectRequestDetail {
	@Autowired
	RequestDetailService service;

	@Test
	void contextLoads() {
		RequestDetailDTO rd = null;
		try {
			rd = service.get("b");
			System.out.println(rd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
