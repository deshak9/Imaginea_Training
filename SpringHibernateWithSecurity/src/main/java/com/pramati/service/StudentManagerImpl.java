package com.pramati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.dao.StudentDAO;
import com.pramati.entity.StudentEntity;

@Service
public class StudentManagerImpl implements StudentManager {

	@Autowired
	StudentDAO studentDAO;
	
	@Transactional
	public void addStudent(StudentEntity student) {
		studentDAO.addStudent(student);
		
	}
	@Transactional
	public List<StudentEntity> getAllStudents() {
		return studentDAO.getStudentsList();
	}
	@Transactional
	public void deleteStudent(Integer studentId) {
		studentDAO.deleteStudent(studentId);
		
	}
	
	public void setStudentDao(StudentDAO studentDao){
		this.studentDAO = studentDao;
	}
}
