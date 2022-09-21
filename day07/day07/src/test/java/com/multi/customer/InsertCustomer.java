package com.multi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@SpringBootTest
class InsertCustomer {
	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		CustomerDTO cust = new CustomerDTO("dyd", "고고고", "남", 30, "대한민국");
		try {
			service.register(cust);
			System.out.println("insert ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
