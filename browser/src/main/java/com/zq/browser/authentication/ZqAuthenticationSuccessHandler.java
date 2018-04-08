package com.zq.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zq.core.properties.SecurityProperties;
import com.zq.core.properties.browsers.LoginResponseType;
import com.zq.core.restful.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/4/8 上午10:10
 * @Package com.zq.browser.authentication
 **/
@Slf4j
@Component("zqAuthenticationSuccessHandler")
public class ZqAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    ObjectMapper objectMapper;

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");

        if (LoginResponseType.JSON.equals(securityProperties.getBrowserProperties().getSignInResponseType())) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            String simpleName = authentication.getClass().getSimpleName();
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ServerResponse.createBySuccess(simpleName)));

        } else {

            // 如果设置了zq.security.browser.singInSuccessUrl，总是跳到设置的地址上
            // 如果没设置，则尝试跳转到登录之前访问的地址上，如果登录前访问地址为空，则跳到网站根路径上

            if (StringUtils.isNotBlank(securityProperties.getBrowserProperties().getSignInSuccessUrl())) {
                requestCache.removeRequest(httpServletRequest, httpServletResponse);
                setAlwaysUseDefaultTargetUrl(true);
                setDefaultTargetUrl(securityProperties.getBrowserProperties().getSignInSuccessUrl());

            }
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication );

        }


    }
}
