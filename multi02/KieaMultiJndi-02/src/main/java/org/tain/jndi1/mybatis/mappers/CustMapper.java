package org.tain.jndi1.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustMapper {

	List<Map<String,Object>> selectAll(Map<String,Object> mapIn);
}
