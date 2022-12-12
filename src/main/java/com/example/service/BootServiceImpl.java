package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BootDao;
import com.example.jsn.Student;
import com.example.jsn.Users;

@Service
public class BootServiceImpl implements BootService {

	@Autowired
	BootDao bootDao;

	@Override
	public Student getStudent(Long studentId) {

		return bootDao.getStudent(studentId);
	}
	
	@Override
	public Users getUser(Integer id) {
		return bootDao.getUser(id);
	}

	@Override
	public Long empLoyeCount() {

		return bootDao.empLoyeCount();
	}

	@Override
	public int employeInsert(String name, Double salary) {
		// TODO Auto-generated method stub
		return bootDao.employeInsert(name, salary);
	}

	@Override
	public int employeUpdate(String name, int salary) {
		// TODO Auto-generated method stub
		return bootDao.employeUpdate(name, salary);
	}
	
	

}
