package com.zq.web.async;


import com.zq.web.beans.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@Slf4j
@RestController
public class AsyncController {

    @Autowired
    private OrderQueue orderQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /**
     * 返回值 必须为 DeferredResult 否则数据不会被存储 直接返回
     * @return
     */
    @ApiOperation(value = "获取订单方法")
    @GetMapping("/order")
    public DeferredResult order(User user, @ApiParam("用户id") String id) {

        String orderNumber = "order_" + UUID.randomUUID().toString();


        orderQueue.setMakeOrder(orderNumber);

        DeferredResult<String> deferredResult = new DeferredResult<>();
        deferredResultHolder.getResultMap().put(orderNumber, deferredResult);

        return deferredResult;
    }
}
