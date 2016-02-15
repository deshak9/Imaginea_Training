package com.pramati.service;

import java.util.List;

import com.pramati.entity.StudentEntity;

public interface StudentManager {
	
	public void addStudent(StudentEntity student);
	public List<StudentEntity> getAllStudents();
	public void deleteStudent(Integer studentId);

}
