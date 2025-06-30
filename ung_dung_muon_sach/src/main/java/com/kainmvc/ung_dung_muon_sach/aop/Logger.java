package com.kainmvc.ung_dung_muon_sach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count = 0;
    @After("execution(* com.kainmvc.ung_dung_muon_sach.*(..))")
    public void countUserVisitedLibrary(){
        count++;
        System.out.println("Tổng số người ghé thư viện là"+ count);
    }
}
