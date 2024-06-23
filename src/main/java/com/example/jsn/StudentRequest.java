package com.example.jsn;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class StudentRequest {
	
	public int empId;
    public String name;
    public ArrayList<Organization> organization;
    public double salary;

}
