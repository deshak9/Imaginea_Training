package com.pramati.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pramati.entity.EmployeeEntity;
import com.pramati.entity.StudentEntity;

public class StudentDaoImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addStudent(StudentEntity student) {
		this.sessionFactory.getCurrentSession().save(student);
	}

	public void deleteStudent(Integer studentId) {
		StudentEntity student = null; 
		try{
			student = (StudentEntity) sessionFactory.getCurrentSession().load(StudentEntity.class, studentId);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(student!=null){
			this.sessionFactory.getCurrentSession().delete(student);
		}
	}

	public List<StudentEntity> getStudentsList() {
		return this.sessionFactory.getCurrentSession().createQuery("from StudentEntity").list();
	}
	
	public void setSessionFactory(SessionFactory session){
		this.sessionFactory=session;
	}

}
