package com.zq.web.async;

import com.zq.core.restful.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
@Slf4j
public class OrderQueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private OrderQueue orderQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(() -> {
            while (true) {
             if (!StringUtils.isEmpty(orderQueue.getCompleteOrder())){
                 String order = orderQueue.getCompleteOrder();
                 log.debug("订单处理结果 :"+ order);
                 ServerResponse bySuccessMessage = ServerResponse.createBySuccessMessage(order);

                 ObjectMapper objectMapper = new ObjectMapper();
                 String s = null;
                 try {
                     s = objectMapper.writeValueAsString(bySuccessMessage);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 deferredResultHolder.getResultMap().get(order).setResult(s);
                 orderQueue.setCompleteOrder(null);
             } else {
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

            }

        }).start();

    }
}
