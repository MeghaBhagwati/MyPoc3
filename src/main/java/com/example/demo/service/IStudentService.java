package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Student;

public interface IStudentService {
	public void saveStudentFile(MultipartFile file);
	public List<Student> findAllStudent();
	public Student findById(Integer id);
	public void saveStudent(Student stu);
	
	
	

}
