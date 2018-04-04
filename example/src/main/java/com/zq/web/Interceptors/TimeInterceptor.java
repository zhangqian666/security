package com.zq.web.Interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        log.info("class : "+((HandlerMethod) handler).getBean().getClass().getName()
        +" ; method :"+((HandlerMethod) handler).getMethod().getName());
        request.setAttribute("startTime", new Date().getTime());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        Long start = (Long) httpServletRequest.getAttribute("startTime");
        log.info("time interceptor 耗时:" + (new Date().getTime() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) throws Exception {
        log.info("afterCompletion");
        Long start = (Long) httpServletRequest.getAttribute("startTime");
        log.info("time interceptor 耗时:" + (new Date().getTime() - start));
        log.info("ex is " + ex);
    }
}
