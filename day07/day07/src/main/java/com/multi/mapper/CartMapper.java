package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.CartDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface CartMapper extends MyMapper<Integer, CartDTO>{

}
