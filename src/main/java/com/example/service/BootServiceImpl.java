package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller_practice.JPMC;
import com.example.controller_practice.SecurityDetail;
import com.example.controller_practice.TransactionDetail;
import com.example.controller_practice.Vanguard;
import com.example.controller_practice.Vanguard_Root;
import com.example.dao.BootDao;
import com.example.jsn.Addresses;
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
	
//	@Override
//	public Addresses getAdd(Integer add_id) {
//		return bootDao.getAdd(add_id);
//	}
	
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

	@Override
	public Addresses getAdd(Integer add_id) {
		// TODO Auto-generated method stub
		return bootDao.getAdd(add_id);
	}

	@Override
	public Addresses getAddd(Integer add_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPMC etfInfo(Vanguard_Root van) {
		
		JPMC jpmc = new JPMC();

		ArrayList<SecurityDetail> secList = new ArrayList<>();
		ArrayList<TransactionDetail> tranList = new ArrayList<>();

		ArrayList<Vanguard> vanObj = van.getVanguard();

		vanObj.stream().forEach(vanLoop -> {

			jpmc.setFileFormat("s");
			jpmc.setFileName("ss");

			SecurityDetail secDet = new SecurityDetail();

			secDet.setEtfOrderId(vanLoop.getEtfOrderId());
			secDet.setSecurityName(vanLoop.getSecName());
			secDet.setTeam(vanLoop.getTeamName());

			secList.add(secDet);

			TransactionDetail tranDet = new TransactionDetail();

			tranDet.setEtfOrderId(vanLoop.getEtfOrderId());
			tranDet.setTransactionDate(vanLoop.getTransactionDate());
			tranDet.setTransactionId(vanLoop.getTransactionId());

			tranList.add(tranDet);
		});

		jpmc.setSecurityDetails(secList);
		jpmc.setTransactionDetails(tranList);

		return jpmc;
	}

//	@Override
//	public Addresses getAdd(Integer add_id) {
//		// TODO Auto-generated method stub
//		return null;
}
	