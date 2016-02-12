package com.pramati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.dao.EmployeeDAO;
import com.pramati.entity.EmployeeEntity;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDAO.addEmployee(employee);
		
	}
	
	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
		
	}

	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
		
	}
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO){
		this.employeeDAO = employeeDAO;
	}
	
}
