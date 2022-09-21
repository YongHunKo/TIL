package com.multi.requestdetail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.RequestDetailDTO;
import com.multi.service.RequestDetailService;

@SpringBootTest
class SelectAllRequestDetail {
	@Autowired
	RequestDetailService service;

	@Test
	void contextLoads() {
		List<RequestDetailDTO> list = null;
		try {
			list = service.getall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(RequestDetailDTO c:list) {
			System.out.println(c);
		}
	}

}
