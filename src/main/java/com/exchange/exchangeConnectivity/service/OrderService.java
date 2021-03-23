package com.exchange.exchangeConnectivity.service;

import com.exchange.exchangeConnectivity.model.OrderInfo;
import com.exchange.exchangeConnectivity.model.OrderServiceResponse;
import com.exchange.exchangeConnectivity.model.clientOrder;
import com.exchange.exchangeConnectivity.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    OrderServiceResponse res= new OrderServiceResponse();

    public OrderServiceResponse data(clientOrder info){


        var status= orderRepository.save(info);

        res.status=200;
        res.message="Order Created successfully";


        return  res;

    }



}
