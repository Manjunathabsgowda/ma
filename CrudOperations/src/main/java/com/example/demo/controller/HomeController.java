package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repositary.StudentRepo;

@RestController
public class HomeController {
	@Autowired
	private StudentRepo studrepo;
	@GetMapping("/")
	public String index()
	{
		return "welcome to crud opertaions";
	}
	@GetMapping("/getAll")
	public List<Integer> getAll(){
		List<Integer> al=new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		return al;	
	}
	//handling for creating new records
	@PostMapping("/saveStudent")
	public Student savedata(@RequestBody Student student)
	{
		studrepo.save(student);
		return student;
	}
	//fetching all data from the database
	@GetMapping("/getstudentall")
	public List<Student> getAlla()
	{
		List<Student> listall=studrepo.findAll();
		return listall;
	}
	@GetMapping("/deletestudent/{rollno}")
	public String deletestu(@PathVariable int rollno)
	{
		Student stud=studrepo.findById(rollno).get();
		if(stud!=null)
			studrepo.delete(stud);
		return "delete succesfully";
		
	}
}
