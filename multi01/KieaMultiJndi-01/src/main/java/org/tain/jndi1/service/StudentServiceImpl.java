package org.tain.jndi1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tain.jndi1.dto.StudentDto;
import org.tain.jndi1.repository.StudentRepository;

@Service
@Transactional(transactionManager = "jndi1TransactionManager") // jndi1에 해당하는 transaction
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public int insertStudent() {
		return studentRepository.insert(new StudentDto("히", 1, 2)) + studentRepository.insert(new StudentDto("비", 1, 2));
	}
	
	@Override
	public List<StudentDto> selectStudentAll() {
		return studentRepository.selectAll();
	}	
}