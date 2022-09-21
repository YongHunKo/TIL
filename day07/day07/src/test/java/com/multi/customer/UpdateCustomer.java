package com.multi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.dto.CustomerDTO;
import com.multi.service.CustomerService;

@SpringBootTest
class UpdateCustomer {
	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		CustomerDTO cust = new CustomerDTO("dyd", "용용용", "남", 29, "대한민국");
		try {
			service.modify(cust);
			System.out.println("update ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
