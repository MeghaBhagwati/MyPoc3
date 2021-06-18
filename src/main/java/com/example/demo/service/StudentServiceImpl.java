package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository repo;

	@Override
	public void saveStudentFile(MultipartFile file) {
		
		try {
			Student stu=new Student();
			
			
		stu.setPhotoUpload(file.getBytes());
		
			stu.setFileName(file.getOriginalFilename());
			stu.setFileType(file.getContentType());
			
		stu.setStuId(stu.getStuId());
		repo.save(stu);
			
		}
		
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		List<Student> list=repo.findAll();
		return list;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		Student student=repo.findById(id).get();
		return student;
	}

	@Override
	public void saveStudent(Student stu) {
		// TODO Auto-generated method stub
		stu.setEmailAddress(stu.getEmailAddress());
		stu.setFirstName(stu.getFirstName());
		stu.setLastName(stu.getLastName());
		stu.setProject(stu.getProject());
		stu.setStuId(stu.getStuId());
		repo.save(stu);
		
	}

}
