package com.example.user.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;

/**
 * desc: 校验参数异常统一处理
 *
 * @author zhangkl
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionAspect extends CommonExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Object handlerBindException(BindException e) {
        log.error("参数绑定错误", e);
        StringBuilder errorMsg = new StringBuilder();
        e.getAllErrors().forEach(x -> errorMsg.append(",").append(x.getDefaultMessage()));
        return randerFail(BaseConstant.FAIL, errorMsg.toString().substring(1));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        return randerFail(BaseConstant.FAIL, "缺少请求参数:" + e.getParameterName());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Object handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("参数类型错误", e);
        return randerFail(BaseConstant.FAIL, "参数[" + e.getName() + "]类型错误");
    }

    @ExceptionHandler(ValidationException.class)
    public Object handlerValidationException(ValidationException e) {
        log.error("参数校验错误", e);
        return randerFail(BaseConstant.FAIL, "参数校验错误");
    }

    @ExceptionHandler(BusinessException.class)
    public Object handlerBusinessException(BusinessException e) {
        log.error("业务异常：" + e.getErrorCode().getMsg(), e);
        return randerFail(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {
        log.error("系统异常", e);
        return randerFail(BaseConstant.FAIL, "系统异常");
    }

}
