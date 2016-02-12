package com.howtodoinjava.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
	}
	
			
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = null; 
		try{
			employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(EmployeeEntity.class, employeeId);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		if(employee!=null){
			this.sessionFactory.getCurrentSession().delete(employee);
		}
		
	}
}
