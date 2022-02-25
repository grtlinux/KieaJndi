package org.tain.jndi2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tain.jndi2.dto.SchoolDto;
import org.tain.jndi2.repository.SchoolRepository;

@Service
@Transactional(transactionManager = "jndi2TransactionManager") // jndi2에 해당하는 transaction
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Override
	public int insertSchool() {
		return schoolRepository.insert(new SchoolDto("로", "라", 3));
	}
	
	@Override
	public List<SchoolDto> selectSchoolAll() {
		return schoolRepository.selectAll();
	}
}