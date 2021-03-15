package com.exchange.exchangeConnectivity.controller;


import com.exchange.exchangeConnectivity.model.OrderInfo;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path="/exchange")
public class ExchangeController {





    @PostMapping(path="/receive")
    public @ResponseBody
    OrderInfo postBody(@RequestBody OrderInfo order)  {

        OrderInfo n = new OrderInfo();


        var oderIds= order.getOrderId();
        var orderAmount = order.getOrderAmount();
        var stock = order.getOrder();

        n.setId(oderIds);
        n.setOrderAmount(orderAmount);
        n.setOrder(stock);

        return n ;


    }


}
