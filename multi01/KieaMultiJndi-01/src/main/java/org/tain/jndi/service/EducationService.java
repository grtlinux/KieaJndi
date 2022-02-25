package org.tain.jndi.service;

import java.util.List;

import org.tain.jndi1.dto.StudentDto;
import org.tain.jndi2.dto.SchoolDto;

public interface EducationService {

	public List<StudentDto> selectStudentAll(); // student 조회
	
	public List<SchoolDto> selectSchoolAll(); // school 조회
	
	public int insertAll(); // student, school 생성
}