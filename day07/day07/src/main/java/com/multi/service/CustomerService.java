package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.CustomerDTO;
import com.multi.frame.MyService;
import com.multi.mapper.CustomerMapper;
@Service
public class CustomerService implements MyService<String, CustomerDTO>{

	@Autowired
	CustomerMapper mapper;
	@Override
	public void register(CustomerDTO v) throws Exception {
		mapper.insert(v);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CustomerDTO v) throws Exception {
		mapper.update(v);
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerDTO get(String k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<CustomerDTO> getall() throws Exception {
		// TODO Auto-generated method stub
		return mapper.select();
	}

}
