package com.zq.web.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("time filters init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("time filters start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        log.info("time filters 耗时:" + (new Date().getTime() - start));
        log.info("time filters finish");

    }

    @Override
    public void destroy() {
        log.info("time filters destroy");
    }
}
