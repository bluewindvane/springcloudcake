package com.yxf.eurekaclient.configuration;

import freemarker.template.SimpleDate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.yxf.eurekaclient.controller..*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        logger.info("方法执行开始");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("START_TIME"+new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss SSS").format(new Date()));
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinpoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfter(Object ret){
//        logger.info("RESPONSE : " + ret);
        logger.info("END_TIME"+new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss SSS").format(new Date()));
        logger.info("方法执行结束");
    }



}
