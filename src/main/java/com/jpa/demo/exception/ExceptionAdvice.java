package com.jpa.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

//@ControllerAdvice
@RestControllerAdvice(basePackages = "com.jpa.demo.rest")
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    private final static Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleControllerException(HttpServletRequest servletRequest, HttpServletResponse res, Throwable e){

        LOG.info("Restful Http请求发生异常...");

        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            LOG.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof NullPointerException) {
            LOG.error("exception is ：" + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.OK.value()).body("发生空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            LOG.error("exception is ：" + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.OK.value()).body("请求参数类型不匹配");
        } else if (e instanceof SQLException) {
            LOG.error("exception is ：" + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.OK.value()).body("数据库访问异常");
        } else {
            LOG.error("exception is ：" + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.OK.value()).body("服务器代码发生异常,请联系管理员");
        }
    }
}
