package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.RequestDetailDTO;
import com.multi.frame.MyService;
import com.multi.mapper.RequestDetailMapper;
@Service
public class RequestDetailService implements MyService<String, RequestDetailDTO>{

	@Autowired
	RequestDetailMapper mapper;
	@Override
	public void register(RequestDetailDTO v) throws Exception {
		mapper.insert(v);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(RequestDetailDTO v) throws Exception {
		mapper.update(v);
		// TODO Auto-generated method stub
		
	}

	@Override
	public RequestDetailDTO get(String k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<RequestDetailDTO> getall() throws Exception {
		// TODO Auto-generated method stub
		return mapper.select();
	}

}
