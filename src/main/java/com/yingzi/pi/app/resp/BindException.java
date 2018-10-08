package com.yingzi.pi.app.resp;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  @description: 参数绑定异常
 *  @author: yaoliang
 *  @date: 2018-08-24-08:55
 **/
@ControllerAdvice
public class BindException extends Exception{


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestResponse bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();


        StringBuilder sb = new StringBuilder();
        sb.append("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage() + ", ");
        }
        RestResponse<String> rest= new RestResponse<>();
        rest.setCode(ExceptionEnum.PARAMERROR.getStatus());
        rest.setMsg(ExceptionEnum.PARAMERROR.getComment()+sb.toString());
        return rest;
    }


}
