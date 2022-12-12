package com.example.service;

import com.example.jsn.Student;
import com.example.jsn.Users;

public interface BootService {
public Student getStudent(Long studentId);
public Users getUser(Integer id);
public Long empLoyeCount() ;
public int employeInsert(String name, Double salary);
public int employeUpdate(String name, int salary);
}
