package org.tain.jndi1.service;

import java.util.List;

import org.tain.jndi1.dto.StudentDto;

public interface StudentService {
	
	public int insertStudent(); // student ์์ฑ
	
	public List<StudentDto> selectStudentAll(); // student ์กฐํ
}