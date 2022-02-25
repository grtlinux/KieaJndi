package org.tain.jndi1.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.tain.jndi1.dto.StudentDto;

@Mapper
public interface StudentRepository {
	
	public int insert(StudentDto studentDto);
	
	public List<StudentDto> selectAll();
}