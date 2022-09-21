package com.multi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.service.CustomerService;

@SpringBootTest
class DeleteCustomer {
	@Autowired
	CustomerService service;

	@Test
	void contextLoads() {
		try {
			service.remove("abc");
			System.out.println("remove ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
