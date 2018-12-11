package com.example.dao;

import com.example.jsn.Student;

public interface BootDao {
public Student getStudent(Long studentId);
public Long empLoyeCount() ;
public int employeInsert(String name, Double salary);
public int employeUpdate(String name, int salary);
}
