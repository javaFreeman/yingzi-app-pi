package com.yingzi.pi.app.common.aop;

import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: yingzi-app-pi
 * @description: 日志打印
 * @author: BaoGuoQiang
 * @create: 2018-10-19 15:25
 **/
@Aspect
@Component
@Slf4j
public class AopLog {
    private static final String START_TIME = "start-request";

    @Pointcut("execution(public * com.yingzi.pi.app.controller.*Controller.*(..))")
    public void log(){}

    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("===============================请求开始=============================");
        log.info("[请求 URL]:{}", request.getRequestURL());
        log.info("[请求 IP]:{}", request.getRemoteAddr());
        log.info("[请求类名]:{}，[请求方法名]：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        Map parameterMap = request.getParameterMap();
        log.info("[请求参数]:{}，", JsonMapper.obj2Str(parameterMap));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    @Around("log()")
    public Object arroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        log.info("[返回值]:{}", JsonMapper.obj2Str(result));
        return result;
    }

    @AfterReturning("log()")
    public void afterReturning(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("[请求耗时]:{}毫秒", end - start);
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("[浏览器类型]:{}，[操作系]:{}，[原始User-Agent]:{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
        log.info("==============================请求结束==============================");
    }
}