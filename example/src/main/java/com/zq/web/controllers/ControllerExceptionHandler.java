package com.zq.web.controllers;

import com.zq.core.restful.ServerResponse;
import com.zq.web.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse handleUserNotExistException(UserNotExistException e) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id", e.getUserid());
        objectMap.put("message", e.getMessage());
        return ServerResponse.createByError(objectMap);

    }
}
