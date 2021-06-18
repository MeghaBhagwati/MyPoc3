package com.example.demo.entity;


import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="Student_Table")

public class Student {
	@GeneratedValue
	@Id
    private Integer stuId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String emailAddress;
	@Column
	@OneToMany(targetEntity=Project.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName="stuId")
	private List<Project> project;
	@Lob
	@Column(name="photo")
	private byte[] photoUpload;
	private String fileType;
	private  String fileName;

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public byte[] getPhotoUpload() {
		return photoUpload;
	}
	public void setPhotoUpload(byte[] photoUpload) {
		this.photoUpload = photoUpload;
	}
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", project=" + project + ", photoUpload=" + Arrays.toString(photoUpload)
				+ ", fileType=" + fileType + ", fileName=" + fileName + "]";
	}
	
	
}
