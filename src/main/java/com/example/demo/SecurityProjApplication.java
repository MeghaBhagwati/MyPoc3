package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SecurityProjApplication {
	 @Autowired
	    private UserRepository repository;

	    @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(101, "megha", "password"),
	                new User(102, "user1", "pwd1"),
	                new User(103, "user2", "pwd2"),
	                new User(104, "user3", "pwd3")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }

	   

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjApplication.class, args);
	}

}
