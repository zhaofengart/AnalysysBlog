package com.analysys.blog.controller;

import com.analysys.blog.common.JsonResult;
import com.analysys.blog.common.RtCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理
 *
 * @author zhaofeng
 * @date 2019/5/25
 */

@ControllerAdvice
public abstract class BaseController {

    @ExceptionHandler(value = Exception.class)
    public JsonResult handle(Exception e){
        System.out.println(e.getMessage());
        return new JsonResult(RtCode.ERROR, e.getMessage());
    }

}
