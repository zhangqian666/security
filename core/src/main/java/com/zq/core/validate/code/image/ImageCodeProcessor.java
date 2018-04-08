package com.zq.core.validate.code.image;


import com.zq.core.validate.code.common.AbstractValidateCodeProcessor;
import com.zq.core.validate.code.common.ValidateCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/4/8 下午1:21
 * @Package com.zq.core.validate.code.image
 **/


@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {


    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getBufferedImage(),"JPEG",request.getResponse().getOutputStream());
    }
}
