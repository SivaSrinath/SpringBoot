package com.example.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jsn.Addresses;
import com.example.jsn.Student;
import com.example.jsn.Users;
import com.example.mod.Customer;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Repository @Slf4j
public class BootDaoImpl implements BootDao{
	
	@Autowired
	NamedParameterJdbcTemplate template;
	

	@Override
	public Student getStudent(Long studentId) {

		String createStudentTable = "SELECT emp_id, name, salary FROM public.emp where emp_id= :empId";
		Map<String,Object> sqlParam=new HashMap<>();
		sqlParam.put("empId",studentId);
		
		List<Map<String,Object>>  resMap = template.queryForList(createStudentTable, sqlParam);
		
		if(resMap.size() > 0) {
			Student student=new Student();
			
			student.setEmpId((Long) resMap.get(0).get("emp_id"));
			student.setName((String) resMap.get(0).get("name"));
			student.setSalary((Double) resMap.get(0).get("salary"));
			
			return student;	
		}
		return null;
	
	}
	
	@Override
	public Addresses getAdd(Integer add_id) {
		
		String createAddressesTable = "SELECT add_id, user_id, street, city, state FROM Addresses where add_id= :addId";
		Map<String, Object> sqlAddParam = new HashMap<>();
		sqlAddParam.put("addId", add_id);
		
		List<Map<String, Object>> addMap = template.queryForList(createAddressesTable, sqlAddParam);
		
		Addresses addd = new Addresses();
		
		addd.setAdd_id((Integer) addMap.get(0).get("add_id"));
		addd.setUser_id((Integer) addMap.get(0).get("user_id"));
		addd.setStreet((String) addMap.get(0).get("street"));
		addd.setCity((String) addMap.get(0).get("city"));
		addd.setState((String) addMap.get(0).get("state"));
		
		return addd;
		}

	@Override
	public Users getUser(Integer id) {
		String userTable = "SELECT id, username, enabled, last_login FROM Users where id = :userId";
		Map<String , Object> sqlUserParam = new HashMap<>();
		sqlUserParam.put("userId",id );
		
		List<Map<String, Object>> userMap = template.queryForList(userTable, sqlUserParam);
		
		Users user = new Users();
		
		user.setId((Integer) userMap.get(0).get("id"));
		user.setUsername((String) userMap.get(0).get("username"));
		user.setEnabled((boolean) userMap.get(0).get("enabled"));
		user.setLast_login((Timestamp) userMap.get(0).get("last_login"));
		
		return user;
	}
	
	public Long empLoyeCount() {
		
		String rmpCount="SELECT count(*) FROM public.emp ";

		return template.queryForObject(rmpCount,(Map) null,Long.class);
	}
	
	public int employeInsert(String name, Double salary) {
		
		String inserQuery= "insert into emp(name, salary) values(:name1,:sal1)";
		Map<String, Object> parmaMap = new HashMap<>();
		parmaMap.put("name1", name );
		parmaMap.put("sal1", salary);
		
		return template.update(inserQuery, parmaMap);
	}
	
	public int employeUpdate(String name, int salary) {
		String updateQuery = "update emp set(name=name1) where salary=sal1";
		Map<String, Object> upMap= new HashMap<>();
		upMap.put("name1", name);
		upMap.put("sal1", salary);
		
		return template.update(updateQuery, upMap);
	}
	
	public int employeInsert(Customer customer) {
		String queryCustomer = "insert ";
		String queryAddress = "insert into Address(id, address, country) values()";
		
		return 0;
		
	}
}