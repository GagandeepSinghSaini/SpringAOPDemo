package com.frys;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {

	@Before("execution(* com.frys.CustomerBoImpl.addCustomer(..))")
	public void addCustomerLogBefore(JoinPoint joinPoint) {
		System.out.println("-------------------------------------------------");
		System.out.println("Before Aspects: Before: addCustomerLogBefore ....");
		System.out.println("Hijacked: "+joinPoint.getSignature());
		System.out.println("-------------------------------------------------");
	}
	
	@After("execution(* com.frys.CustomerBoImpl.addCustomer(..))")
	public void addCustomerLogAfter(JoinPoint join) {
		System.out.println("-------------------------------------------------");
		System.out.println("After Aspects: After: addCustomerLogAfter ....");
		System.out.println("Hijacked: "+join.getSignature());
		System.out.println("-------------------------------------------------");
	}
	
	@AfterReturning(pointcut = "execution(* com.frys.CustomerBoImpl.addCustomerReturnValue(..))",
			returning = "result")
	public void addCustomerLogAfterReturning(JoinPoint join, Object result) {
		System.out.println("-------------------------------------------------");
		System.out.println("@AfterReturning Aspects: @AfterReturning: addCustomerLogAfterReturning ....");
		System.out.println("Hijacked: "+join.getSignature());
		System.out.println("Returned Value: "+result);
		System.out.println("-------------------------------------------------");
	}
	
	@AfterThrowing(pointcut = "execution(* com.frys.CustomerBoImpl.addCustomerThrowException(..))",
			throwing = "error")
	public void addCustomerLogThrowException(JoinPoint join, Throwable error) {
		System.out.println("-------------------------------------------------");
		System.out.println("@AfterThrowing Aspects: @AfterThrowing: addCustomerLogThrowException ....");
		System.out.println("Hijacked: "+join.getSignature());
		System.out.println("Throwing Exception: "+error);
		System.out.println("-------------------------------------------------");
	}
	
	@Around("execution(* com.frys.CustomerBoImpl.addCustomerAround(..))")
	public void addCustomerLogAround(ProceedingJoinPoint join) throws Throwable {
		System.out.println("-------------------------------------------------");
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + join.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(join.getArgs()));
			
		System.out.println("Around before is running!");
		join.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
			
		System.out.println("******");
		System.out.println("-------------------------------------------------");
	}
	
}
