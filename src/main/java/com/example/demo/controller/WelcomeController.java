package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AuthRequest;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImpl;
import com.example.demo.util.JwtUtil;

@RestController
public class WelcomeController {
	 @Autowired
	    private  StudentServiceImpl service;
	
	
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }
    @GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		
		List<Student> stu=service.findAllStudent();
		ResponseEntity<List<Student>> resp=null;
		resp=new ResponseEntity<List<Student>>(stu,HttpStatus.OK);
		return resp;
		
	}
    @GetMapping("/getById")
	public ResponseEntity<Student> getStudentById(@RequestParam(value="id" ,required=true) Integer id ){
		
		Student stu=service.findById(id);
		ResponseEntity<Student> resp=null;
		resp=new ResponseEntity<Student>(stu,HttpStatus.OK);
		return resp;
		
	}
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveAllStudent(@RequestBody Student stu ){
     service.saveStudent(stu);	
     ResponseEntity<String> resp=null;
		resp=new ResponseEntity<String>("saved",HttpStatus.CREATED);
		
		return resp;
	}
	 @PostMapping("/savefile") 
	 public void saveStudent(@RequestParam Integer id,@RequestParam("file") MultipartFile multipartfile){
	 
	  
	  
	service.saveStudentFile(multipartfile);
	 
	 }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}