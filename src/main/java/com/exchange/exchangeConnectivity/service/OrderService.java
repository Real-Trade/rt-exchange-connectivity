package com.exchange.exchangeConnectivity.service;
import com.exchange.exchangeConnectivity.model.ClientOrder;
import com.exchange.exchangeConnectivity.model.OrderServiceResponse;
import com.exchange.exchangeConnectivity.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    OrderServiceResponse res= new OrderServiceResponse();

    public OrderServiceResponse data(ClientOrder info){

        var orderId = info.getOrderId();
var client = info.getClient();

var clientid=client.getClientId();

//        Optional<ClientOrder> cash = orderRepository.findById(clientid);
//
//       System.out.println("message from db " + cash);
//
//        cash.setStatus(info.getStatus());
//        cash.setExchangeOrderId(info.getExchangeOrderId());
//        cash.setClient(info.getClient());
//
//        orderRepository.save(cash);

        res.status=200;
        res.message="Order Created successfully";

        return  res;

    }



}
