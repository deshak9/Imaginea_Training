package com.pramati.dao;

import java.util.List;

import com.pramati.entity.StudentEntity;

public interface StudentDAO {
	
	public void addStudent(StudentEntity student);
	public void deleteStudent(Integer studentId);
	public List<StudentEntity> getStudentsList();
}
