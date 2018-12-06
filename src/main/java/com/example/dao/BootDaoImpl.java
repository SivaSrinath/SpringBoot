package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jsn.Student;

@Repository
public class BootDaoImpl implements BootDao{
	
	@Autowired
	NamedParameterJdbcTemplate template;

	@Override
	public Student getStudent(Long studentId) {

		String createStudentTable = "SELECT emp_id, name, salary FROM public.emp where emp_id= :empId";
		Map<String,Object> sqlParam=new HashMap<>();
		sqlParam.put("empId",studentId);
		
		List<Map<String,Object>>  resMap=template.queryForList(createStudentTable, sqlParam);
		
		Student student=new Student();
		
		student.setEmpId((Long) resMap.get(0).get("emp_id"));
		student.setName((String) resMap.get(0).get("name"));
		
		student.setSalary((Double) resMap.get(0).get("salary"));
		
		return student;
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
}