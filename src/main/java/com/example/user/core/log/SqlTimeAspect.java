package com.example.user.core.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 打印sql执行时间
 *
 * @author zhangkl
 */
@Aspect
@Component
@Slf4j
public class SqlTimeAspect {
    /**
     * 添加了该注释之后，就可以在代码中直接饮用log.info( ) 打印日志了
     */
    @Pointcut("execution(* com.example.user.dao..*.*(..))")
    private void pointCutMethod() {
    }

    /**
     * 声明环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.nanoTime();
        Object obj = pjp.proceed();
        long end = System.nanoTime();

        log.info("调用Mapper方法：{}，参数：{}，耗时：{}毫秒", pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()),
                (end - begin) / 1000000);
        return obj;
    }

}
