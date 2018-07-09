package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Lee on 2018/7/9.
 */
@Aspect
public class LogListener {
    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..))||execution(* com.baizhi.cmfz.service.impl.*.add*(..))||execution(* com.baizhi.cmfz.service.impl.*.remove*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){

        //ID
        String id= UUID.randomUUID().toString().replace("-","");

        //获取session,进而获取操作对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        String user=manager.getMgrName();

        Date date=new Date();

        Class clazz = pjp.getTarget().getClass();

        String className = clazz.getName();
        String resource=className.replace("ServiceImpl","").replace("com.qyg.cmfz.serviceImpl.","");

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String name = method.getName();
        String action="";
        if(name.contains("add")){
            action="新增";
        }else if(name.contains("remove")){
            action="删除";
        }else if(name.contains("modify")){
            action="修改";
        }
        Object[] args = pjp.getArgs();
        String message="";
        for (Object arg : args) {
            message+=arg;
        }
        Object obj="";
        String result="";
        try {
            obj = pjp.proceed();
            result="success";
        } catch (Throwable throwable) {
            result="fail";
            throwable.printStackTrace();
        }
        if(user==null){
            result="false";
        }
        Log log=new Log(id,user,date,resource,action,message,result);
        logService.appendLog(log);
        return obj;
    }
}
