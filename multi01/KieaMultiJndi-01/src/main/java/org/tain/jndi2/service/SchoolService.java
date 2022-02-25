package org.tain.jndi2.service;

import java.util.List;

import org.tain.jndi2.dto.SchoolDto;

public interface SchoolService {
	
	public int insertSchool(); // school 생성
	
	public List<SchoolDto> selectSchoolAll(); // school 조회
}