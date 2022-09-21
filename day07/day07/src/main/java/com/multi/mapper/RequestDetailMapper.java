package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.RequestDetailDTO;
import com.multi.frame.MyMapper;
@Repository
@Mapper
public interface RequestDetailMapper extends MyMapper<String, RequestDetailDTO> {

}
