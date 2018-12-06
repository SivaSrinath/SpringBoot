package com.example.controller;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AOPConfig {

	@Before(value="execution(* com.example.*.*.*(..))")
	public void before(JoinPoint joinPoint) {

		System.out.println("AOP");
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		System.out.println("AOP");
	}

	@AfterReturning(pointcut = "execution(* com.example.controller.*.*(..))", returning = "retunValue")
	public void after(JoinPoint joinPoint, Object retunValue) {
		System.out.println("AOP");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(retunValue);
		System.out.println("AOP");
	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.*.*(..))", throwing = "ex")
	public void whileException(JoinPoint joinPoint, Exception ex) {
		System.out.println("AOP");
		ex.printStackTrace();
		System.out.println("AOP");
	}
}
