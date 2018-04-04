package com.zq.core.properties.browsers;

import com.zq.core.properties.SecurityConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/4/4 下午4:36
 * @Package com.zq.core.properties.browsers
 **/


@Getter
@Setter
public class BrowserProperties {

    private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;
}
