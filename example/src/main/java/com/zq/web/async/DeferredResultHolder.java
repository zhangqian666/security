package com.zq.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class DeferredResultHolder {


    private Map<String,DeferredResult<String>> resultMap = new HashMap<>();

    public Map<String, DeferredResult<String>> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, DeferredResult<String>> resultMap) {
        this.resultMap = resultMap;
    }
}
