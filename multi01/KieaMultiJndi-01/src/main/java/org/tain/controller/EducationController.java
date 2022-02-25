package org.tain.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.jndi.service.EducationService;

@RestController
public class EducationController {
	
	@Autowired
	EducationService educationService;
	
	@GetMapping("/selectAll")
	public ResponseEntity<Object> selectAll() {
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("student", educationService.selectStudentAll());
		resultMap.put("school", educationService.selectSchoolAll());
		
		return new ResponseEntity<Object>(resultMap, HttpStatus.OK);
	}
}