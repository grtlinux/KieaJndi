package org.tain.jndi2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.tain.jndi2.dto.SchoolDto;

@Mapper
public interface SchoolRepository {
	
	public int insert(SchoolDto schoolDto);
	
	public List<SchoolDto> selectAll();
}