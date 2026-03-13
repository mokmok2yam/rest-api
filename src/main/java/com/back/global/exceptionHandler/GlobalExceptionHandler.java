package com.back.global.exceptionHandler;

import com.back.global.rsData.RsData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    public RsData<Void> handleException(){
        return new RsData<Void>(
                "존재하지 않는 데이터입니다.",
                "404-1"
        );
    }
}