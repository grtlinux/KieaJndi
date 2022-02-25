package org.tain.jndi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tain.jndi1.dto.StudentDto;
import org.tain.jndi1.service.StudentService;
import org.tain.jndi2.dto.SchoolDto;
import org.tain.jndi2.service.SchoolService;

@Service
public class EducationServiceImpl implements EducationService {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	SchoolService schoolService;
	
	@Override
	public List<StudentDto> selectStudentAll() {
		return studentService.selectStudentAll();
	}
	
	@Override
	public List<SchoolDto> selectSchoolAll() {
		return schoolService.selectSchoolAll();
	}
	
	@Override
	public int insertAll() { // student와 school의 transaction 처리가 다름
		return studentService.insertStudent() + schoolService.insertSchool();
	}
}