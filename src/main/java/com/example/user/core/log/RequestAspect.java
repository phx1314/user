package com.example.user.core.log;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 打印接口参数和返回值
 *
 * @author zhangkl
 */
@Aspect
@Component
@Slf4j
public class RequestAspect {

    private LogModel logModel;

    @Pointcut("execution(public * com.example.user.controller..*.*(..))")
    public void restControllerlog() {
    }

    @Before("restControllerlog()")
    public void exBefore(JoinPoint joinPoint) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        logModel = new LogModel();
        logModel.setUri(request.getRequestURL().toString());
        logModel.setQueryString(request.getQueryString());
        logModel.setReqIp(request.getRemoteAddr());
        logModel.setStartTime(DateTime.now().toDate());
        logModel.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logModel.setParams(request.getParameterMap());

        log.info("log = " + JSON.toJSONString(logModel));
    }

    @After("restControllerlog()")
    public void exAfter(JoinPoint joinPoint) {
        log.info("class method:" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName() + "方法执行完毕！");
    }

    @AfterReturning(returning = "result", pointcut = "restControllerlog()")
    public void exAfterReturning(Object result) {
        log.info("执行返回值：" + JSON.toJSONString(result));
    }

    @Data
    public static class LogModel {

        private String uri;

        private Date startTime;

        private Date endTime;

        private Long tookTime;

        private Object result;

        private String reqIp;

        private Boolean success = Boolean.FALSE;

        private String errMsg;

        private Object queryString;

        private String method;

        private String classMethod;

        private Map params;

    }

}
