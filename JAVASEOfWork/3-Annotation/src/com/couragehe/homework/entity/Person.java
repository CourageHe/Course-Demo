package com.couragehe.homework.entity;

import com.couragehe.homework.annotaion.Column;
import com.couragehe.homework.annotaion.Entity;
import com.couragehe.homework.annotaion.ID;

@Entity("People")
public class Person {
	@ID
	@Column(nullable= false)
	private Integer id;
	@Column(nullable=false,length = 16)
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
