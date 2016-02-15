package com.pramati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pramati.entity.EmployeeEntity;
import com.pramati.entity.StudentEntity;
import com.pramati.service.EmployeeManager;
import com.pramati.service.StudentManager;

@Controller
@RequestMapping(value="/student")
public class EditStudentController {
	@Autowired
	private StudentManager studentManager;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String listStudents(ModelMap map){
		map.addAttribute("student", new StudentEntity());
		map.addAttribute("studentList", studentManager.getAllStudents());
		return "editStudentList";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute(value="student") StudentEntity student, BindingResult result){
		studentManager.addStudent(student);
		return "redirect:/student/";
	}
	
	@RequestMapping(value = "/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Integer studentId){
		studentManager.deleteStudent(studentId);
		return "redirect:/student/";
	}
	
	public void setStudentManager(StudentManager studentManager){
		this.studentManager = studentManager;
	}

}
