package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsn.Addresses;
import com.example.jsn.Student;
import com.example.jsn.StudentRequest;
import com.example.jsn.Users;
import com.example.jsn.Youtube;
import com.example.service.BootService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BootController {

	@Autowired
	BootService bootService;

	@PostMapping("getAndReturnYoutube")
	public Youtube getAndReturnYoutube(@RequestBody List youtube) {

		System.out.println("Return youtube");
		return null;
	}
	
	@PostMapping("inserStudentInfo")
	public Object insertStudentData(@RequestBody StudentRequest studentRequest) {
		return null;
	}

	@ExceptionHandler
	public String errorController(HttpMessageNotReadableException e) {
		// e.printStackTrace();
		System.out.println("*****************" + e.getClass().getName());
		return e.getMessage();
	}
	/*
	 * @ExceptionHandler public String errorController1(Exception e) { //
	 * e.printStackTrace(); System.out.println("*****************" +
	 * e.getClass().getName()); return e.getMessage(); }
	 */

	@PostMapping("sample")
	public String getSample() {

		return "Siva";

	}


	//http://localhost:9090/add?no1=5&num2=10&num3=5

	//http://localhost:9090/add?no1=10&&num2=2
	@GetMapping("add")
	public int add(@RequestParam(name = "no1") int num1, @RequestParam int num2,
			@RequestParam(required = false) Integer num3) {

		if (num3 != null) {
			return num1 + num2 + num3;
		}

		return num1 + num2;
	}
	
	
	
	//http://localhost:9090/add?no1=5&num2=10&num3=5
	//http://localhost:9090/add/300
	@GetMapping("add/{usha}")
	public int addPath(@PathVariable Integer usha) {
		return usha;
	}
	
	

	@DeleteMapping("deleterecord/{primaryKey}")
	public String deleteRecord(@PathVariable int primaryKey) {
		//
		return "Record Delted :" + primaryKey;
	}

	//http://localhost:9090/getStudent?studentId=10
	@GetMapping("getStudent")
	public Student getStudent(@RequestParam Long studentId) {

		Student st = bootService.getStudent(studentId);
		return st;
	}
	
	@GetMapping("getAdd")
	public Addresses getAdd (@RequestParam Integer add_id) {
		
		Addresses add = bootService.getAdd(add_id);
		return add;
	}
	
	
	@GetMapping("getUser")
	public Users getUser(@RequestParam Integer id) {
		
		return bootService.getUser(id);
	}
	
	@GetMapping("test")
	public String getTest() {

		return "Siva";
	}

	@DeleteMapping("empLoyeCount")
	public Long empLoyeCount() {
		return bootService.empLoyeCount();
	}

	@GetMapping("empoyeInsert")
	public int employeInsert(@RequestParam String name, @RequestParam Double salary, HttpServletRequest req) {
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("salary"));

		return bootService.employeInsert(name, salary);
	}

	@GetMapping("empoyeUpdate")
	public int employeUpdate(@RequestParam String name, @RequestParam Integer salary, HttpServletRequest req
			, @RequestHeader String test) {
		System.out.println("Request header is :"+ test);
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("salary"));

		return bootService.employeUpdate(name, salary);
	}
	
	
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	
	
	  @POST	  
	  @Path("/")	  
	  @ApiOperation(value = "create household", response = Object.class)
	  @ApiResponses(value = {
			  //@ApiResponse(code = HttpStatus.OK, message = "", response = Object.class),
			  //@ApiResponse(code = HttpStatus.ACCEPTED, message = "", response = ExceptionResponse.class)
	  })
	 public Object craeteHousehold() {
	  
		  
	  return new Integer(0); 
	  }
	 
}