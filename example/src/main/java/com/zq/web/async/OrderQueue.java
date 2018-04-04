package com.zq.web.async;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class OrderQueue {


    private String makeOrder;
    private String completeOrder;

    public String getMakeOrder() {
        return makeOrder;
    }

    public void setMakeOrder(String makeorder) {
        this.makeOrder = makeorder;
        new Thread(() -> {
            log.debug("下单成功，生成订单号 :" + makeorder);
            try {
                Thread.sleep(2000);
                completeOrder = makeorder;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("订单完成");
        }
        ).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
