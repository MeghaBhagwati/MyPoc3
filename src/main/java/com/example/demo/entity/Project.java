package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project_Table")
public class Project {
	@Id
	@GeneratedValue
	@Column
private Integer projId;
	@Column
private String javaProject;
	@Column
private String phpProject;
	@Column
private String microProject;
public String getJavaProject() {
	return javaProject;
}
public void setJavaProject(String javaProject) {
	this.javaProject = javaProject;
}
public String getPhpProject() {
	return phpProject;
}
public void setPhpProject(String phpProject) {
	this.phpProject = phpProject;
}
public String getMicroProject() {
	return microProject;
}
public void setMicroProject(String microProject) {
	this.microProject = microProject;
}
@Override
public String toString() {
	return "Project [javaProject=" + javaProject + ", phpProject=" + phpProject + ", microProject=" + microProject
			+ "]";
}

}
