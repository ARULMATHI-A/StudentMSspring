package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	@Column
	private String passwd;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDetail studentDetail;
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public void setPasswd(String passwd) {
		this.passwd=passwd;
	}
	
	public StudentDetail getStudentDetail() {
	    return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
	    this.studentDetail = studentDetail;
	}
	
}
