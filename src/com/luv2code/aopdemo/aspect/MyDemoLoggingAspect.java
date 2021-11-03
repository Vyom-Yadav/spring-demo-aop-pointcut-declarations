package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Using a common pointcut expression, @Pointcut used to declare a pointcut
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
        // pointcut expression
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setterMethod() {
        // pointcut expression
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getterMethod() {
        // pointcut expression
    }

    // this is where we add all our related advices for logging

    // let's start with a @Before advice
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======>>> Executing @Before Advice");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Performing API analytics");
    }

    // combining pointcut expressions
    @Before("forDaoPackage() && !(getterMethod() || setterMethod())")
    public void logToCloud() {
        System.out.println("\n=======>> Some Advice");
    }
}
